angular.module('starter.services',['ngResource'])

.factory('TaxiService', function ($http){
	return {
		getRating: function(license){
			return $http.get('http://localhost:8080/safetaxi/webapi/taxis/placas/'+license).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		}
	}
})


.factory('TaxiService2', function ($http){
	return {
		getTaxi: function(license){
			return $http.get('http://localhost:8080/safetaxi/webapi/taxis/'+license).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		}
	}
})

