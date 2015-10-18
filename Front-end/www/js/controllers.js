angular.module('starter.controllers', ['ngOpenFB', 'starter.services'])

.controller('AppCtrl', function($scope, $ionicModal, $timeout, ngFB, ManageUser) {

  // With the new view caching in Ionic, Controllers are only called
  // when they are recreated or on app start, instead of every page change.
  // To listen for when this page is active (for example, to refresh data),
  // listen for the $ionicView.enter event:
  //$scope.$on('$ionicView.enter', function(e) {
  //});

  // Form data for the login modal
  $scope.loginData = {};

  // Create the login modal that we will use later
  $ionicModal.fromTemplateUrl('templates/login.html', {
    scope: $scope
  }).then(function(modal) {
    $scope.modal = modal;
  });

  // Triggered in the login modal to close it
  $scope.closeLogin = function() {
    $scope.modal.hide();
  };

  // Open the login modal
  $scope.login = function() {
    $scope.modal.show();
  };

  // Perform the login action when the user submits the login form
  $scope.doLogin = function() {
    console.log('Doing login', $scope.loginData);

    // Simulate a login delay. Remove this and replace with your login
    // code if using a login system
    $timeout(function() {
      $scope.closeLogin();
    }, 1000);
  };
  $scope.fbLogin = function () {
    ngFB.login({scope: 'email'}).then(
      function (response) {
        if (response.status === 'connected') {
          console.log('Facebook login succeeded');
          //$localStorage.accessToken = response.access_token;
          $scope.closeLogin();
          $scope.toggleLoginButtons();
          $scope.getUser();
        } else {
          alert('Facebook login failed');
        }
      });
    
  };
  $scope.getUser = function(){
    ngFB.api({
        path: '/me',
        params: {fields: 'id,name'}
    }).then(
        function (user) {
            $scope.user = user;
            ManageUser.setUser(user);
        },
        function (error) {
            alert('Facebook error: ' + error.error_description);
        });
  }
  $scope.fbLogout = function(){
     ngFB.logout().then(
                    function() {
                        alert('Logout successful');
                    },
                    alert('Logout unsuccessful'));

    $scope.toggleLoginButtons();
  };
  $scope.toggleLoginButtons = function(){
    $scope.loginButton= !($scope.loginButton);
    $scope.logoutButton= !($scope.logoutButton);
    $scope.profile = !($scope.profile);
  };
})
.controller('ProfileCtrl', function ($scope, ngFB, ManageUser) {
    ngFB.api({
        path: '/me',
        params: {fields: 'id,name'}
    }).then(
        function (user) {
            $scope.user = user;
            ManageUser.setUser(user);
        },
        function (error) {
            alert('Facebook error: ' + error.error_description);
        });
})
.controller('PlaylistsCtrl', function($scope, $http, TaxiService, ManageUser, ngFB) {
  $scope.user = ManageUser.getUser();
  $scope.$watch(function () { return ManageUser.getUser(); }, function (newValue, oldValue) {
        if (newValue != null) {
            //update Controller2's xxx value
            $scope.user= newValue;
        }
    }, true);
  licenseToCode = function(license){
    var code="";
    for(var i = 0;i < 3;i++){
      code = code.concat(charToNum(license.substr(i,i+2)));
    }
    code = code.concat(license.substr(license.length-3));
    return code;
  }
  charToNum = function(letter){
    letter = letter.toUpperCase();
    var code = '0';
    code = code.concat(letter.charCodeAt(0)-64);
    code = code.substr(code.length-2);
    return code;
  }
  $scope.getLicense = function(license){
    console.log(license);
    license = licenseToCode(license);
    console.log(license);
    $scope.myColor = "white";
    $scope.estado = "";

    TaxiService.getRating(license).then(function(response){
      $scope.placas = response.data;
      $scope.estado = "Puntaje: " + $scope.placas;

      if($scope.placas >= 3){
        $scope.myColor = "green";   
      }else 
      if($scope.placas >= 2){
        $scope.myColor = "orange";   
      }else
      $scope.myColor = "red";   
      if($scope.placas == 0){
        $scope.estado="No ha sido calificado, calificalo y gana 20 puntos!";
        $scope.myColor="white";
      }
    },function(err) {
      console.error('ERR', err);
    // err.status will contain the status code
  })

    return $scope.estado;
  }

})
.service('ManageUser', function(){
  var user;
  return{
      getUser: function(){
        return user;
      },
      setUser: function(myUser){
        console.log("changing user");
        user = myUser;
      }
  };
})
.controller('PlaylistCtrl', function($scope, $stateParams) {
});
