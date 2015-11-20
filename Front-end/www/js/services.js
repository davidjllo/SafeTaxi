angular.module('starter.services',['ngResource'])

.factory('TaxiService', function ($http){
	var UrlBase= "www.safetaxi.elasticbeanstalk.com/webapi";
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
		sendRating: function(license, rating, comment, userId){
			var ratingObject = [{
				"rating": rating,
				"comment": comment,
				"hash": license,
				"userId": userId
			}]
			console.log("Funcionaaa", ratingObject);
			return $http.post(UrlBase+'taxis/rate/', ratingObject).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		},
		sendUser: function(id){

			return $http.get(UrlBase+'usuarios/validos/'+id).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		},
		updateScore: function(scoreObject){
			return $http.put(UrlBase+'usuarios/score',scoreObject).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		},
		getUser: function(id){

			return $http.get(UrlBase+'usuarios/'+id).then(function(resp) {
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
		}


		/* setBrand: function(taxi){
			return $http.put(UrlBase+"/taxis/make", taxi){
			console.log("Brand set");
				user = resp;
				return user;
			}, function(err) {
				console.error('ERR', err);

			});
*/
		}
})
