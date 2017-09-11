
  
  app.controller('ng-app-controller-bbdd',
['$scope', '$http', '$timeout','utilFactory', function ($scope, $http, $timeout, utilFactory)
  {
    $scope.testOk = false;

    $scope.test = function ()
    {
      //usamos utilFactory(app.factory) para almacenar las veces que se realiza el test de la bbddd  
      utilFactory. setContadortBBDD(utilFactory.getContadorBBDD() + 1);
      
      $http.post('/test',
      {
        table: 'propiedad del objeto'
      })
      .then(function (response)
      {
        
        var data = response.data;
        

        $scope.testOk = true;
        $scope.bbdd = data;

        $timeout(function ()
        {
          $scope.testOk = false;
        }, 5000);
      });
    };


  }]);