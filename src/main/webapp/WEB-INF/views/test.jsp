<!DOCTYPE html>

<html>

<head>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>

<script>

'use strict';

 var handler = angular.module('MyService',[]);
 
 handler.factory('StudentService', function($http,$q){
	var REST_URL = 'http://localhost:7001/mywork/';
	var factory={
			getAllStudents : getAllStudents,
			deleteStudent : deleteStudent,
			updateStudent : updateStudent,
			addStudent : addStudent
	};
	return factory;
	
	function getAllStudents(){
		var deferred = $q.defer();
		console.log("##Service getAllStudents()##");
		$http.get(REST_URL+'student/getAllStudents').then(
				function(response){
					deferred.resolve(response.data);
				}, function(errResponse){
					console.error(errResponse);
					deferred.reject(errResponse);
				});
		return deferred.promise;
	}
	
	function updateStudent(student){
		var deferred = $q.defer();
		console.log("##Service updateStudent()##");
		$http.put(REST_URL+'student/updateStudent',student).then(
				function(response){
					deferred.resolve(response.data);
				}, function(errResponse){
					console.error(errResponse);
					deferred.reject(errResponse);
				});
		return deferred.promise;
	}
	
/* 	function addStudent(student){
		var deferred = $q.defer();
		console.log("##Service addStudent()##");
		$http.post(REST_URL+'student/addStudent',student).then(
				function(response){
					deferred.resolve(response.data);
				}, function(errResponse){
					console.error(errResponse);
					deferred.reject(errResponse);
				});
		return deferred.promise;
	} */
	
	function addStudent(student){
		var deferred = $q.defer();
		console.log("##Service addStudent()Newwwww##");
		$http({
			method : 'POST',
			url : REST_URL+'student/addStudent',
			data : angular.toJson(student),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(
				function(response){
					deferred.resolve(response.data);
				}, function(errResponse){
					console.error(errResponse);
					deferred.reject(errResponse);
				});
		return deferred.promise;
	}
	
	function deleteStudent(student){
		var deferred = $q.defer();
		console.log("##Service deleteStudent()##");
		$http.delete(REST_URL+'student/deleteStudent',student).then(
				function(response){
					deferred.resolve(response.data);
				}, function(errResponse){
					console.error(errResponse);
					deferred.reject(errResponse);
				});
		return deferred.promise;
	}
 });
 
</script>

<script>

var app = angular.module('StudentApp',['MyService']);
var con = app.controller('studentController', studentController);
con.$inject = ['$scope', '$http'];

function studentController($scope, StudentService){
	var self = this;
	$scope.student = {};
	self.students = [];
	$scope.message = '';
	
	getAllStudents();
	
	function getAllStudents(){
		console.log("##Controller getAllStudents()##");
		$scope.message = 'Getting All Students Data';
		StudentService.getAllStudents().then(function(data){
			self.students = data;
		}, function(errResponse){
			console.error(errResponse);
		});
	}
	
	$scope.deleteStudent = function(student){
		console.log("##Controller deleteStudent()##");
		StudentService.deleteStudent().then(function(data){
			$scope.message = 'Deleted a Student';
			getAllStudents();
		}, function(errResponse){
			console.error(errResponse);
		});
	}
	
	$scope.edit = function(student){
		console.log("####Controller edit()####");
		$scope.student = student;
	}
	
	$scope.add = function(student){
		console.log("####Controller add()####");
		StudentService.addStudent(student).then(function(data){
			$scope.message = 'Added a Student';
			getAllStudents();
		}, function(errResponse){
			console.error(errResponse);
		});
	}
	
	$scope.update = function(student){
		console.log("##Controller update()##");
		
		StudentService.updateStudent(student).then(function(data){
			$scope.message = 'Updated a Student';
			getAllStudents();
		}, function(errResponse){
			console.error(errResponse);
		});
	}
}

</script>

</head>

<body ng-app="StudentApp">

<div ng-controller="studentController as ctrl">
<h3>{{message}}</h3>

<table class="table">
<tr>
	<td>ID:</td>
	<td><input type="text" name="id" ng-model="student.id"/></td>
</tr>
<tr>
	<td>Name:</td>
	<td><input type="text" name="name" ng-model="student.name"/></td>
</tr>
<tr>
	<td>City:</td>
	<td><input type="text" name="city" ng-model="student.city"/></td>
</tr>	
<tr>
	<td><button type="button" ng-click="update()">Update</button></td>
	<td><button type="button" ng-click="add()">Add</button>
	<button type="button" ng-click="clear()">Clear</button></td>
</tr>
</table>

<table border="1" class="table">
<tr>
<th>ID</th>
<th>Name</th>
<th>City</th>
<th>Action</th>
</tr>

<tr ng-repeat="student in ctrl.students">
	<td><span ng-bind="student.id"></span></td>
	<td><span ng-bind="student.name"></span></td>
	<td><span ng-bind="student.city"></span></td>
	<td><button type="button" ng-click="edit(student)">Edit</button>
	<button type="button" ng-click="deleteStudent(student)">Delete</button></td>
</tr>
</table>



</div>

</html>