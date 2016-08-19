angular.module('scopeExample', [])
.controller('MyController',function($scope, $http) {
  $scope.greeting = ' ';
  
  $scope.sayHello = function() {
      $http.get('/retrieve/' + $scope.username ).
      success(function(data, status, headers) {
          $scope.greeting = $scope.username + " works at " + data.value;
          $scope.status = status;
          $scope.headers = headers;
          
     //     request.getResponseHeader("x-pivotal-ip-address");
      });
  };
});