const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let JobSchema = new Schema({
    ministryName: {
        type: String
    },
    orgName: {
        type: String
    },
    position: {
        type: String
    },
    startDate: {
        type: String
    },
    applyBy: {
        type: String
    },
    location: {
        type: String
    },
    description: {
        type: String
    },
    eligibility: {
        type: String
    }
});

const Job = mongoose.model('Job', JobSchema);

module.exports = Job;