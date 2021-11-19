var express = require("express");
var router = express.Router();
var apparel = require("../models/apparel")


router.get("/", function(req, res){
   res.render("landing");
});

router.get("/apparel", function(req, res){
    apparel.find({}, function(err, apparel){
        if(err){
            console.log(err);
        }else{
            res.render("apparel",{apparel: apparel});
        }
    });
});


router.get("/apparel/new", function(req, res){
   res.render("apparel/new");
});

router.post("/apparel", function(req, res){
   var name = req.body.name;
   var image = req.body.image;
   var description = req.body.description;
   var author = {
        id: req.user._id,
        username: req.user.username
    };
   //create new campground
   var Newapparel = {name: name, image: image, description:description, author:author};
   apparel.create(Newapparel, function(err, newlyCreated){
        if(err){
            console.log(err);
        }else{
            console.log(newlyCreated);
            res.redirect("/apparel");
        }
   });
});


router.get("/apparel/:id", function(req, res){
       apparel.findById(req.params.id).populate("comments").exec(function(err, foundapparel){
       if(err){
           console.log(err);
       } else{
            res.render("apparel/show", {apparel:foundapparel});
       }
    });

});

router.get("/apparel/:id/edit", function(req, res){
    apparel.findById(req.params.id, function(err, foundapparel){
            if(err){
                console.log(err);
            }else{
                    res.render("apparel/edit", {apparel:foundapparel});
            }
    });
});

router.put("/apparel/:id" , function(req, res){
    apparel.findByIdAndUpdate(req.params.id, req.body.apparel, function(err, updatedapparel){
        if(err){
               console.log(err);
               res.redirect("/apparel");
           } else {
               //redirect somewhere(show page)
               req.flash("success", "Successfully updated Apparel!");
               res.redirect("/apparel/" + req.params.id);
           }
    });
});

router.delete("/apparel/:id", function(req, res){
    apparel.findByIdAndRemove(req.params.id, function(err, removedapparel){
        if(err){
            console.log(err);
        }else{
            req.flash("success", "Apparel deleted!");
            res.redirect("/apparel");
        }
   });
});

module.exports = router;
