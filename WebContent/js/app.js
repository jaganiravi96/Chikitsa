var myApp = angular.module('myApp',['ngRoute']);
myApp.config(['$routeProvider', function($routeProvider){
	$routeProvider.
	when('/second',{
		templateUrl:'views/second.html',
		controller:'SecondController'
	}).

	when('/main',{
		templateUrl:'views/main.html'
	}).
	when('/signup',{
		templateUrl:'views/signup.html',
		controller:'SignupController'
	}).
	otherwise({
      redirectTo: '/main'
    });
    
}]);