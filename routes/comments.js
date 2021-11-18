var express = require("express");

var router = express.Router();
var apparel = require("../models/apparel");
var Comment = require("../models/comments");


router.get("/apparel/:id/comments/new", function(req, res){
    apparel.findById(req.params.id, function(err, foundapparel){
        if(err){
            console.log(err);
        }else{
            res.render("comments/new", {apparel:foundapparel});
        }
    });
});

router.post("/apparel/:id/comments", function(req, res){
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