var express = require("express");
var router = express.Router();
var passport = require("passport");
var User = require("../models/users");


//=============
//adding login forms
router.get("/login", function(req,res){
    req.flash("success", "successfully logged in");
    res.render("login");
});

router.post("/login", passport.authenticate("local",
        {
            successRedirect:"/login",
            failureRedirect: "/login"
        }), function(req, res){
});

//==============
//adding logout route
router.get("/logout", function(req, res){
   req.logout();
   req.flash("success", "Logged out!");
   res.redirect("/");
});

module.exports = router;
