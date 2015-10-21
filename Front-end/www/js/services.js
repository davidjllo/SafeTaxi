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
		},
		getTaxi: function(license){
			return $http.get('http://localhost:8080/safetaxi/webapi/taxis/'+license).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		},
		sendRating: function(license, rating, comment){
			console.log("Entró al tercer servicio con factory");
			return $http.post('http://localhost:8080/safetaxi/webapi/taxis/rate/'+license+"/"+rating+"/"+comment).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		}

	}
})




