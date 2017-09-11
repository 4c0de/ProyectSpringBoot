  
  app.controller('ng-app-controller-insertar',
['$scope','$timeout','$http', function ($scope, $timeout, $http)
  {

  $scope.addElement = function()
  {
                    $http.post('insertar',
                    {
                        id:null,
                        nombre:$scope.nombre,
                        categoria:$scope.categoria,
                        descripcion:$scope.descripcion,
                        url:$scope.url
                      })
                    .then(function ()
                     {
                         $scope.nombre = "";
                         $scope.categoria = "";
                         $scope.descripcion = "";
                         $scope.url = "";        
                        
                     }); 
     
  };


  
   $scope.reset = function()
  {
     $scope.nombre = "";
     $scope.categoria = "";
     $scope.descripcion = "";
     $scope.url = "";
     
  };


}]);
