//Para poder, pasado 2000ms que nos mande a la pantalla principal. Le pasamos $location
  
  app.controller('ng-app-controller-about',
['$scope','$timeout', '$location','utilFactory', function ($scope, $timeout, $location, utilFactory)
  {
    $scope.tiempo = true;
    //Para mostrar las veces que hemos testeado la bbdd
     $scope.contador = utilFactory.getContadorBBDD();

        $timeout(function ()
        {
          $scope.tiempo = false;
          //url a la que nos llevará
           $location.url("");
        }, 2000);

  }]);