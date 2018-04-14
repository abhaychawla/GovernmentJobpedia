const mongoose = require('mongoose');

//Connect to database
mongoose.connect(process.env.DATABASE_URL);

const db = mongoose.connection;
db.on('error', function(err) {
    console.log('Database connection error: '+ err.message);
});
db.once('open', function() {
    console.log('Connected to database!');
});

module.exports = mongoose;