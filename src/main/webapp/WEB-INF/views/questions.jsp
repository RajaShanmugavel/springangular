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

	app.controller('questionsController', function($scope, $http) {

		$scope.iqquestions = [];
		$scope.iqquestionsForm = {
			qId : "",
			qTxt : ""
		};

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
		
		$scope.submitQuestions = function(options){
			console.log("##submitQuestions()##");
			$http({
				method : 'POST',
				url : REST_URL + 'submitQuestions',
				data : $scope.options
				/* data : angular.toJson($scope.options), */
				/* headers : {
					'Content-Type' : 'application/json'
				} */
			});
		}

	});
</script>

</head>

<body ng-app="questionsApp" ng-controller="questionsController">

	<form>
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">

				<tr ng-repeat="question in iqquestions">
					<td><input type="hidden" value="question.questionId" />*</td>
					<td>{{question.questionText}}</td>
					<td ng-repeat="op in question.options">
						<input type="hidden" value="op.optionId" /> <input type="checkbox" value="op.optionText" />
						{{op.optionText}}
					</td>
				</tr>
				<tr>
				<td colspan="3"><button id="submitAns" class="btn btn-primary btn-sm" ng-click="submitQuestions(options)">Submit</button></td>
				</tr>
			</table>
		</div>
		
	</form>

</body>

</html>
