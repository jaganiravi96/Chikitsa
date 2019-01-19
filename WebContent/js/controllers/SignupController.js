
myApp.controller('SignupController',['$scope', '$http', function($scope, $http ){
	$scope.signupsuccess=false;
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
            $scope.signupsuccess=true;
            console.log($scope.signupsuccess);
            
      }, function () {}
      );
		
	}
	
	$scope.login=function(){
		console.log("hitting js login");
		console.log($scope.userName);
		$http({
			url:"http://localhost:8081/Chikitsa_final/Service",
			method:"get",
			params:{
				"reqflag":"loginform",
				"userName":$scope.userName,
				"password":$scope.loginPassword
			}
		}).then(function () {
            console.log("success");
           
            
      }, function () {}
      );
	}
	
	
	$scope.createPatientProfile=function(){
		console.log("hitting js createpatient");
		console.log($scope.aadharPatient);
		$http({
			url:"http://localhost:8081/Chikitsa_final/Service",
			method:"get",
			params:{
				"reqflag":"Appointment",
				"aadhar":$scope.aadharPatient,
				"illness":$scope.illness,
				"symptoms":$scope.symptoms,
				"duration":$scope.duration,
				"medication":$scope.medication,
				"mHistory":$scope.medicalHistory,
				"gHistory":$scope.genericHistory,
				"severity":$scope.severity
			}
		}).then(function () {
            console.log("success");
           
            
      }, function () {}
      );
	}
	
	
}]);