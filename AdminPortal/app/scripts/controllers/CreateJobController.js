(function () {
    'use strict';

    angular
        .module('app')
        .controller('CreateJobController', function(MainService, $window) {
            var vm = this;

            vm.postJob = function() {
                MainService.postJob(vm.job).then(function(res) {
                    $window.location.href = 'http://localhost:8081/dashboard';
                });
            };

        });

})();