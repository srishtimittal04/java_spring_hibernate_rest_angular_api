
angular.module('formModule',[]).controller('dataController',function($scope,$http,$window){
	
					//CREATE
	$scope.responseMessage={};
	$scope.person = {}; 		//just declaring a variable, good practice	//it will bind data from .html person.name, person.city...
	var urlDemo='http://localhost:9999/spring-app/person/';
	var methodDemo='';
	
	$scope.saveOrUpdate=function(id){	
	//	alert("SUBMIT");
		if(id)					//called only after update() //id=$scope.person.id
		{
			urlDemo+='update';
			methodDemo='PUT';
		}
		else									//called initially
		{
			urlDemo+='create';
			methodDemo='POST';
		}
		
		/*					//VALIDATING
			var check='1';
			var name=$scope.person.name;
			var city=$scope.person.city;
		
		    var nameReg = /^[A-Za-z0-9]+$/;
		    var isOnlyCharacters = nameReg.test(name);
			var cityReg = /^[A-Za-z]+$/;
			var isCharAndSpecial = cityReg.test(city);
			
		//	$('#status').val(true);
			var name = $('#name').val();
			var contactReg = /^\d{10}$/;
			var validContact = contactReg.test(contact);
			 if (!validAge) {
			   $('#age').after('<span class="error">Enter a valid age</span>');
			   $('#status').val(false);
			 }
			var check=$('#status').val();	//
		
		
				//validating name
		if(name.length<'1'){
			alert("emp name should not be blank");
			check='0';
			return 'false';
		}
		if(!isOnlyCharacters){
			alert("emp name should contains only char");
			check='0';
			return 'false';
		}
				//validating city
		if(name.length<'1'){
			alert("emp city should not be blank");
			check='0';
			return 'false';
		}
		if(!isCharAndSpecial){
			alert("emp city should be valid");
			check='0';
			return 'false';
		}
		if(check==='1'){}
	*/
	
		if($scope.addemp.$valid){
			$http({
				'url' : urlDemo,
				'method' : methodDemo,
				'headers': {'Content-Type' : 'application/json'},
				'data' :  JSON.stringify($scope.person)
				}).
			then(
				function successCallback(response){
					$scope.responseMessage = JSON.stringify(response); //response.data
					$scope.msg="............data saved...........";
					$scope.FunCall();								//to refresh table data as there is any change
				},
				function myError(response){
					$scope.msg=".............error .............: "+JSON.stringify(response);
				}
			);
	//	$window.location.reload();
		}
	};	
		
				//DISPLAY
	$scope.FunCall = function () {
	$scope.persons ={};
		$http({
				'url' : 'http://localhost:9999/spring-app/person/details',
				'method' : 'GET'
				}).
			then(
				function(response){
					$scope.msg="............displays person info...........";
					$scope.persons = response.data;
				}
			);
	};
		
					//DELETE
	$scope.delete=function(id){
		alert(id+" will be deleted");
		$http({
			'url' : 'http://localhost:9999/spring-app/person/delete/'+id,
			'method' : 'DELETE',
			}).
		then(
			function(response){
				$scope.msg="............data deleted...........";
				$scope.FunCall();
			}
		);	
	};	
	
				//UPDATE
	$scope.person = {};	
	$scope.update=function(id){	
		$http({
			'url' : 'http://localhost:9999/spring-app/person/details/'+id,
			'method' : 'GET'
			}).
		then(
			function(response){
				$scope.person = response.data;
				$scope.buttonName='UPDATE';
				$scope.msg="............please update the employee info...........";
			}
		);
		
				
	};	
	
	
						//VALIDATIONS
/*	$scope.AddEmp= function() {
		var name=$scope.person.name;
		var city=$scope.person.city;
		var isValid=1;
		var isOnlyCharacters=/^[a-zA-Z]+$/.test(username);
		var isCharAndSpecial=/^[0-9]+$/.test(city);
		
					//validating name
		if(name.length<1){
			alert("emp name should not be blank");
			return 'false';
		}
		if(!isOnlyCharacters){
			alert("emp name should contains only char");
			return 'false';
		}
				//validating city
		if(name.length<1){
			alert("emp city should not be blank");
			return 'false';
		}
		if(!isCharAndSpecial){
			alert("emp city correct");
			return 'false';
		}
	};
*/
		
});


				//to enable CORS in browser(in cmd in chrome.exe folder)
//chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security