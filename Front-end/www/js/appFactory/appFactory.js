/*global angular*/

(function () {
    'use strict';

    var starter = angular.module('starter');

    starter.factory('appFactory', ['$http', function ($http) {

        var urlBase = 'http://localhost:8080/safetaxi/webapi/',
            WS = {};

        //WS asociados a Usuarios

        WS.getRating = function (license) {
            return $http.get(urlBase + 'taxis/placas/' + license);
        };

        WS.getUsuario = function (username) {
            return $http.get(urlBase + 'usuarios/' + username);
        };

        WS.getUsuarioAutorizado = function (username, password) {
            return $http.get(urlBase + 'usuarios/' + username + '/' + password);
        };

        WS.addUsuario = function (usuario) {
            return $http.post(urlBase + 'usuarios', usuario);
        };

        WS.getNombreUsuario = function (username) {
            WS.getUsuario(username).success(function (data) {
                return $http.get(urlBase + 'terceros/' + data.idTercero);
            });
        };

        //WS asociados a Imagenes

        WS.getImagenes = function () {
            return $http.get(urlBase + 'download');
        };
        
         WS.upload = function (file) {
            return $http.post(urlBase + 'upload', file, file);
        };

        //WS asociados a Tercero

        WS.getTercero = function (idTercero) {
            return $http.get(urlBase + 'terceros/' + idTercero);
        };

        //WS asociados a Modulos y ModulosUsuario

        WS.getModulosUsuario = function (idUsuario) {
            //return $http({method: 'GET', url: urlBase + 'modulos/getModulosUsuario/' + idUsuario + '?format=json', headers: {'Access-Control-Allow-Origin': 'localhost:*'}});
            return $http.get(urlBase + 'modulos/getModulosUsuario/' + idUsuario);
        };

        return WS;
    }]);

    
}());
