
angular.module('formModule',[]).controller('displayController',function($scope,$http){
			$scope.persons ={};
		$http({
			'url' : 'http://localhost:9999/spring-app/person/details',
			'method' : 'GET',
			//'headers': {'Content-Type' : 'application/json'},
			//'data' :  JSON.stringify($scope.person)
			}).
		then(
			function(response){
				$scope.msg="............displays person info...........";
				$scope.persons = response.data;
			}
		);
	
});