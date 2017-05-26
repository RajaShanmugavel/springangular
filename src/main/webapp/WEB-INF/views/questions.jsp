<!DOCTYPE html>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script>
	var app = angular.module('questionsApp', []);
	var REST_URL = 'http://localhost:7001/mywork/';

	app.controller('questionsController', function($scope, $http, $filter) {

		$scope.selectedList = [];
		
		loadQuestions();

		function loadQuestions() {
			console.log("##loadQuestions()##");
			$http({
				method : 'GET',
				url : REST_URL + 'getRandomQuestionsAndAnswers'
			}).then(function successCallback(response) {
				$scope.iqquestions = response.data;
			}, function errorCallback(errResponse) {
				console.error(errResponse);
			});
		}
		
		$scope.selectedOptions = function(){
			console.log("##selectedOptions...##");
			/* $scope.optionsArray = [];
			angular.forEach($scope.iqquestions, function(question){
				console.log("ques:"+question.questionId);
				angular.forEach(question.options, function(option){
					console.log("ops:"+option.optionId);
					console.log("sel:"+option.checked);
					console.log("selid:"+$scope.selectedOptionId);
				});
			}); */
			//console.log("iqquestions.options:"+$scope.iqquestions[0].options[0].optionId);
			//$scope.selectedList = $filter('filter')($scope.iqquestions, {selectedOptionId:true});
			$scope.selectedList = $filter('filter')($scope.iqquestions, function(opt){
				return opt;				
			});
		}
		
		$scope.submitQuestions = function(){
			console.log("##submitQuestions()##");
			//console.log("##selectedList##"+$scope.selectedList); 
			$http({
				method : 'POST',
				url : REST_URL + 'submitQuestions',
				data : angular.toJson($scope.selectedList),
				headers : {
					'Content-Type' : 'application/json'
				}
			});
		}
		
		
		$scope.toggleSelection = function(fruitName){
			console.log("##toggleSelection()##");
			var idx = $scope.selection.indexOf(fruitName);
			console.log("idx:"+idx);
			console.log("sel:"+$scope.selection);
			
			if(idx > -1){
				$scope.selection.splice(idx,1);
			}else{
				$scope.selection.push(fruitName);
			}
		}

	});
</script>



</head>

<body ng-app="questionsApp" ng-controller="questionsController">

	<form>
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">

				<tr ng-repeat="question in iqquestions">
				<td>{{question.questionText}}</td>
				<td ng-repeat="op in question.options">
					<input type="checkbox" name="{{op.optionId}}" id={{op.optionId}} ng-model="op.selectedOptionId" ng-change="selectedOptions()">
					{{op.optionText}}
				</td>	
				</tr>
				<tr>
				<td colspan="3"><button id="submitAns" class="btn btn-primary btn-sm" ng-click="submitQuestions()">Submit</button></td>
				</tr>
			</table>
			<!-- Selected List  {{selectedList}} -->
		</div>
		
	</form>

</body>

</html>
