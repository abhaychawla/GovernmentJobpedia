(function () {
    'use strict';

    angular
        .module('app')
        .controller('DashboardController', function(MainService) {
            var vm = this;

            vm.getJobs = function() {
                MainService.getJobs().then(function(res) {
                    vm.jobs = res.data;
                });
            };

            vm.getJobs();

        });

})();