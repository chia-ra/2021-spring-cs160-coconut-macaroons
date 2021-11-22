var express = require("express");
var app = express();
var mongoose = require("mongoose");
var bodyparser = require("body-parser");
var methodOverride = require("method-override");
var apparel = require("./models/apparel");
var apparelRoutes = require("./routes/apparel");
var commentRoutes = require("./routes/comments");
var indexRoutes = require("./routes/index");
var  passport = require("passport");
var  User = require("./models/users");
var  LocalStrategy = require("passport-local");
var flash = require("connect-flash");

mongoose.connect("mongodb+srv://RoshanV24:jack24jack@cluster0.brmnu.mongodb.net/myFirstDatabase?retryWrites=true&w=majority", {useNewUrlParser: true });

app.use(bodyparser.urlencoded({ extended:true}));
app.set("view engine", "ejs");
app.use(express.static(__dirname + "/public"));
app.use(methodOverride("_method"));
app.use(flash());

app.use(require("express-session")({
    secret: "secret",
    resave: false,
    saveUninitialized: false
}));

app.use(passport.initialize());
app.use(passport.session());
passport.use(new LocalStrategy(User.authenticate()));

passport.serializeUser(User.serializeUser());
passport.deserializeUser(User.deserializeUser());


app.use( function(req, res, next) {
    res.locals.currentUser = req.user;
    //console.log(req.user);
    res.locals.error = req.flash("error");
    res.locals.success = req.flash("success");
   next();
});


app.use(apparelRoutes);
app.use(commentRoutes);
app.use(indexRoutes);

app.listen(process.env.PORT,process.env.IP, function(){
    console.log("Server is Running...");
});
const PORT = 8080;
const HOST = 'localhost';
app.listen(PORT, HOST, "/apparel" () => console.log("listening " + PORT));
