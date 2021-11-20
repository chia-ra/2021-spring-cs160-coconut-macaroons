var apparel = require("../models/apparel"), 
    Comment    = require("../models/comments");
var middlewareObj = {};

middlewareObj.isLoggedIn = function(req,res,next){
    if(req.isAuthenticated()){
        return next();
    }else{
        req.flash("error", "Please Login First!")
        res.redirect("/login");
    }
};

middlewareObj.checkapparelOwnership = function(req,res,next){
     if(req.isAuthenticated()){
        apparel.findById(req.params.id, function(err, foundapparel){
            console.log(foundapparel.author.id);
            if(err){
                req.flash("error", "Campground not found.");
                console.log(err);
                res.redirect("back");
            }else{
                if(foundapparel.author.id.equals(req.user._id)){
                    next();
                }else{
                    req.flash("error", "You do not have permission to do that.");
                    res.redirect("back");
                }
            }
        });
    }else{
        //console.log("You need to be logged in to do that");
        req.flash("error", "You need to be logged in to that");
        res.redirect("back");
    }
};
middlewareObj.checkCommentOwnership = function(req,res,next){
     if(req.isAuthenticated()){
        Comment.findById(req.params.comment_id, function(err, foundComment){
            if(err){
                console.log(err);
                res.redirect("back");
            }
            else{
                if(foundComment.author.id.equals(req.user._id)){
                    next();
                }else{
                    req.flash("error"," You do not have permission to do that");
                    res.redirect("back");
                }
            }
            
        });
    }else{
        req.flash("error", "Something went wrong :(");
        res.redirect("back");
    }
}


module.exports = middlewareObj;