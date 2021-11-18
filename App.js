var express = require("express");
var app = express();
var mongoose = require("mongoose");

mongoose.connect("mongodb+srv://RoshanV24:jack24jack@cluster0.brmnu.mongodb.net/myFirstDatabase?retryWrites=true&w=majority", {useNewUrlParser: true });

app.listen(process.env.PORT,process.env.IP, function(){
    console.log("Server is Running...");
});
const PORT = 8080;
const HOST = 'localhost';
app.listen(PORT, HOST, () => console.log("listening " + PORT));
