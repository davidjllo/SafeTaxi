angular.module('starter.controllers', ['ngOpenFB', 'starter.services', 'ionic-ratings','ngCordova'])

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
.controller('ProfileCtrl', function($scope, ngFB, ManageUser) {
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

.controller('PlaylistsCtrl', function($scope, $http, TaxiService, TransferData, ManageUser, ngFB, ManageLicense) {
  $scope.estado = "";
  $scope.myColor = "white";
  console.log("BACKHERE");
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

  $scope.clearAll = function(){
    location.reload();
  }
  $scope.takeService = function(license){
    ManageLicense.setLicense(license);
  }
  $scope.getLicense = function(license){
    console.log(license);
    license = licenseToCode(license);
    console.log(license);
    $scope.myColor = "white";
    $scope.estado = "";

    TaxiService.getRating(license).then(function(response){
      $scope.puntaje = response.data;
      $scope.estado = "Puntaje: " + $scope.puntaje.toFixed(1);

      if($scope.puntaje >= 3){
        $scope.myColor = "green";   
      }else 
      if($scope.puntaje >= 2){
        $scope.myColor = "orange";   
      }else
      $scope.myColor = "red";   
      if($scope.puntaje == 0){
        $scope.estado="No ha sido calificado, calificalo y gana 20 puntos!";
        $scope.myColor="white";
      }
    },function(err) {
      console.error('ERR', err);
    // err.status will contain the status code
  })

    return $scope.estado;
  }

  $scope.sendDataCalificar = function(license){
      $scope.taxiRating = "";
      console.log(license);
      license = licenseToCode(license);
      console.log(license);
      TransferData.setTaxi(license);
      
      return $scope.taxiRating;
  }

})

.controller('CalificarCtrl', function($scope, $http, TaxiService, TransferData, ManageUser, ngFB) {
    $scope.placaTaxi = TransferData.getTaxi();
    getRating();
    function getRating (){
      console.log($scope.placaTaxi, "El onload está funcionando");
      TaxiService.getTaxi($scope.placaTaxi).then(function(response){
        console.log(response, "Este es el response del json")
        $scope.taxi = response.data;
      },function(err) {
      console.error('ERR', err);
      // err.status will contain the status code
      }) 
    }
    $scope.clearAll = function(){
    location.reload();
  }

    $scope.sendRating = function(comment){
      TaxiService.sendRating($scope.placaTaxi, $scope.ratingsObject.rating, comment).then(function(response){
        console.log(response, "this is my response");
      },function(err) {
      console.error('ERR', err);
      // err.status will contain the status code
      }) 
      console.log("Rating has been sent, yaay!");
      $scope.clearAll();
  }


      $scope.ratingsObject = {
        iconOn : 'ion-ios-star',
        iconOff : 'ion-ios-star-outline',
        iconOnColor: 'rgb(255, 201, 0)',
        iconOffColor:  'rgb(138, 138, 138)',
        rating:  3,
        minRating:1,
        callback: function(rating) {
          $scope.ratingsCallback(rating);
        }
      };

      $scope.ratingsCallback = function(rating) {
        console.log('Selected rating is : ', rating);
      };

})

.controller('TrackCtrl', function($scope, $ionicLoading, ManageLicense){
    var marker;
    
    $scope.dropPin = function(pos){
      marker = new google.maps.Marker({
                                                    position: new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude),
                                                    map: $scope.map,
                                                    title:"My Position"
                                                    });
    }
    $scope.mapCreated = function(map) {
      console.log("mapCreated");
    $scope.map = map;
    $scope.centerOnMe();

    
  };
  $scope.sharePos = function(){
    //Falta corregir!!!
    // $cordovaSocialSharing
    // .shareViaWhatsApp('Tomé un taxi de placas: '+ManageLicense.getLicense(), null /* img */, null /* url */, function() {console.log('share ok')}, function(){alert("error!")});
    
  }
  $scope.centerOnMe = function () {
    console.log("Centering");
    if (!$scope.map) {
      return;
    }

    $scope.loading = $ionicLoading.show({
      content: 'Getting current location...',
      showBackdrop: false
    });

    navigator.geolocation.getCurrentPosition(function (pos) {
      console.log('Got pos', pos);
      $scope.map.setCenter(new google.maps.LatLng(pos.coords.latitude, pos.coords.longitude));
      $scope.dropPin(pos);
      $ionicLoading.hide();
    }, function (error) {
      alert('Unable to get location: ' + error.message);
    });
  };
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

.service('TransferData', function(){
  var taxiRating;
  return{
      getTaxi: function(){
        return taxiRating;
      },
      setTaxi: function(myTaxiRating){
        taxiRating = myTaxiRating;
      }
  };
})

.service('ManageLicense', function(){
  var license;
  return{
      getLicense: function(){
        return license;
      },
      setLicense: function(myLicense){
        license = myLicense;
      }
  };
})

.controller('PlaylistCtrl', function($scope, $stateParams) {
});
