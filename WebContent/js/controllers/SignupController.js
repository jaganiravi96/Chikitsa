
myApp.controller('SignupController',['$scope', '$http', function($scope, $http ){
	$scope.signup=function(){
		console.log("HERE");
		console.log($scope.firstName);
		$http({
			url:"http://localhost:8081/Chikitsa_final/Service",
			method:"get",
			params :{
				"reqflag":"signup",
				"password":$scope.password,
				"firstname":$scope.firstName,
				"lastname":$scope.lastName,
				"aadhar":$scope.aadhar,
				"phone":$scope.phone
			}
		}).then(function () {
            console.log("success");
      }, function () {

      }
      );
		
	}
}]);