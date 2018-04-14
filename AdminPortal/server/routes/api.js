const express = require('express');

const router = express.Router();

//Models
const Job = require('../models/job');

router.post('/job', function(req, res) {
    var job = new Job();
    console.log(req.body);
    job.ministryName = req.body.ministryName;
    job.orgName = req.body.orgName;
    job.position = req.body.position;
    job.startDate = req.body.startDate;
    job.applyBy = req.body.applyBy;
    job.location = req.body.location;
    job.description = req.body.description;
    job.eligibility = req.body.eligibility;
    job.save(function(err) {
        if(err) {
            console.log(err);
        }
        else {
            console.log('Saved!');
            res.json({ success: true });
        }
    });
});

router.get('/jobs', function(req, res) {
    Job.find({}, function(err, jobs) {
        console.log(jobs);
        res.json(jobs);
    });
});

module.exports = router;