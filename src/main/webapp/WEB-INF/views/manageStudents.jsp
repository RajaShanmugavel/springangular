<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>

<script>
	var app = angular.module('MyApp',[]);
	var REST_URL = 'http://localhost:7001/mywork/';
	
	app.controller('MyAppController', function($scope, $http){
		$scope.students = []
		$scope.studentsForm = {
				id : "",
				name : "",
				city : ""
		};
		
		getStudentDetails();
		
		function getStudentDetails(){
			console.log("##getStudentDetails()##");
			$http({
				method : 'GET',
				url : REST_URL+'student/getAllStudents'
			}).then(function successCallback(response){
				$scope.students = response.data;
			}, function errorCallBack(errReponse){
				console.log(errResponse);
			});
		}
		
		$scope.editStudent = function(student){
			console.log("##editStudent()##");
			$scope.studentsForm.id = student.id;
			$scope.studentsForm.name = student.name;
			$scope.studentsForm.city = student.city;
		}
		
		$scope.deleteStudent = function(student){
			console.log("##deleteStudent()##");
			$http({
				method : 'DELETE',
				url : REST_URL+'student/deleteStudent',
				data : angular.toJson(student),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getStudentDetails());
		}
		
		
	});
</script>

</head> 

<body ng-app="MyApp" ng-controller="MyAppController">

	<form>
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 600px">
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" ng-model="studentsForm.id" size="30"/></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" ng-model="studentsForm.name" size="30" /></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>City:</td>
				<td><input type="text" name="city" ng-model="studentsForm.city" /></td>
				<td></td>
				<td></td>
			</tr>
			
			<tr ng-repeat="student in students">
			<td>{{ student.id}}</td>
			<td>{{ student.name}}</td>
			<td>{{ student.city}}</td>
			<td>
			<a ng-click="editStudent(student)" class="btn btn-primary btn-sm">Edit</a>
			<a ng-click="deleteStudent(student)" class="btn btn-danger btn-sm">Delete</a>
			</td>
			</tr>
		</table>
		</div>
	</form>

</body>

</html>