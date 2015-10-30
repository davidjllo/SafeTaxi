angular.module('starter.services',['ngResource'])

.factory('TaxiService', function ($http){
	var UrlBase= "http://localhost:8080/safeTaxi/webapi/";
	return {
		getRating: function(license){
			return $http.get(UrlBase+"taxis/placas/"+license).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		},
		getTaxi: function(license){
			return $http.get(UrlBase+'taxis/'+license).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		},
		sendRating: function(license, rating, comment){
			console.log("Entró al tercer servicio con factory");
			return $http.post(UrlBase+'taxis/rate/'+license+"/"+rating+"/"+comment).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		},
		setBrand: function(taxi){
			return $http.put(UrlBase+"/taxis/make", taxi);
		}.then(function(resp) {
			console.log("Brand set");
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});

	}
})




