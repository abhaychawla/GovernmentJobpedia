(function () {
    'use strict';

    angular
        .module('app')
        .factory('MainService', function($http) {
            var mainFactory = {};

            mainFactory.getJobs = function() {
                return $http.get('/api/jobs');
            }

            mainFactory.postJob = function(job) {
                return $http.post('/api/job', job);
            }

            return mainFactory;
        })

})();