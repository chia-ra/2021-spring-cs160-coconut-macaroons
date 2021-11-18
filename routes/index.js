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


module.exports = router;