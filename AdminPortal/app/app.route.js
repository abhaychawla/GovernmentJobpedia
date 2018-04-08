(function () {
    'use strict';

    angular
        .module('app')
        .config(['$routeProvider', '$locationProvider', function($routeProvider, $locationProvider) {
            
            $routeProvider
                .when('/', {
                    templateUrl: 'views/main.html',
                    controller: 'MainController',
                    controllerAs: 'vm'
                })
                .when('/dashboard', {
                    templateUrl: 'views/dashboard.html',
                    controller: 'DashboardController',
                    controllerAs: 'vm'
                })
                .when('/createjob', {
                    templateUrl: 'views/createjob.html',
                    controller: 'CreateJobController',
                    controllerAs: 'vm'
                });

            $locationProvider.html5Mode(true);

        }]);   

})();