const path = require('path');
const express = require('express');
const morgan = require('morgan');
const bodyParser = require('body-parser');
const api = require('./server/routes/api');

//Config
require('dotenv').config();

//Database
require('./server/database/database'); 

//Init app
const app = express();

//Middleware
//Logging Requests
app.use(morgan('dev'));
//Parsing Requests
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
//Serve Static Files
app.use(express.static(path.join(__dirname, './app')));

//Routes
app.use('/api', api);

app.get('*', function(req, res) {
    res.sendFile(path.join(__dirname, './app/index.html'));
});

//Server
app.listen(process.env.PORT, function() {
    console.log('Gym Main Listening to PORT '+ process.env.PORT +'!');
});