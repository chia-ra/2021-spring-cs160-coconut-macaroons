var express = require("express");
var router = express.Router();
var apparel = require("../models/apparel");
var Comment = require("../models/comments");
var middleware = require("../middleware")

router.get("/apparel/:id/comments/new",middleware.isLoggedIn, function(req, res){
    apparel.findById(req.params.id, function(err, foundapparel){
        if(err){
            console.log(err);
        }else{
            res.render("comments/new", {apparel:foundapparel});
        }
    });
});

router.post("/apparel/:id/comments", middleware.isLoggedIn, function(req, res){
    apparel.findById(req.params.id, function(err, foundapparel){
       if(err){
           console.log(err);
           res.redirect("/apparel");
       }else{
           Comment.create(req.body.comment, function(err, newComment){
                if(err){
                    console.log(err);
                }else{
                    newComment.text = req.body.comment.text;
                    newComment.author.id = req.user._id;
                    newComment.author.username = req.user.username;
                    //save comment
                    newComment.save();
                    foundapparel.comments.push(newComment);
                    foundapparel.save();
                    req.flash("success", "Successfully added Comment");
                    console.log(newComment);
                    res.redirect('/apparel/' + foundapparel._id);
                }           
               
           })
       } 

    });
});

router.get("/apparel/:id/comments/:comment_id/edit",middleware.checkCommentOwnership, function(req, res){
    Comment.findById(req.params.comment_id, function(err, foundComment) {
        if(err){
            console.log(err);
        }else{
            res.render("comments/edit",{apparel_id: req.params.id,comment:foundComment});
        }        
    });
    
});

router.put("/apparel/:id/comments/:comment_id", function(req,res){
    Comment.findByIdAndUpdate(req.params.comment_id, req.body.comment, function(err, updatedComment){
        if(err){
            console.log(err);
            res.redirect("back");
        }else{
             req.flash("success", "Successfully updated Comment");
             res.redirect('/apparel/' + req.params.id);
        }
        
    });
});

router.delete("/apparel/:id/comments/:comment_id",middleware.checkCommentOwnership, function(req, res){
   Comment.findByIdAndRemove(req.params.comment_id, function(err, deletedComment){
       if(err){
           console.log(err);
       }else{
            req.flash("success", "Successfully deleted Comment");
            res.redirect('/apparel/' + req.params.id);
       }
   }) 
});
module.exports = router;
    