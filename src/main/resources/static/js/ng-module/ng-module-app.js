//inicializamos modulo app
var app = angular.module('app', ['ngRoute','ngSanitize']);

//ngRoute encargado de las redirecciones.

app.config(['$routeProvider', '$locationProvider',
  function ($routeProvider, $locationProvider)
  {
    $routeProvider.otherwise(
    {
      redirectTo: '/'
    })
    .when('/',
    {
      templateUrl: GBL_COFG.urlTemplate('inicial.html')
    })
    .when('/testbbdd',
    {
      templateUrl: GBL_COFG.urlTemplate('testbbdd.html'),
      controller: 'ng-app-controller-bbdd'
    })
    .when('/about',
    {
      templateUrl: GBL_COFG.urlTemplate('about.html'),
      controller: 'ng-app-controller-about'
    })
    
     .when('/buscador',
    {
      templateUrl: GBL_COFG.urlTemplate('buscador.html'),
      controller: 'ng-app-controller-buscador'
    })
      .when('/insertar',
    {
      templateUrl: GBL_COFG.urlTemplate('insertar.html'),
      controller: 'ng-app-controller-insertar'
    })
    .when('/kirby',
    {
      templateUrl: GBL_COFG.urlTemplate('kirby.html')
   
    });
  }]);

//directiva para cargar y remover la clase de carga para el gif
app.directive('apploading',
['$http', function ($http)
  {
    var loading =
    {
      restrict: 'A',
      link: function (scope, elm, attrs)
      {
        scope.isLoading = function ()
        {
          return $http.pendingRequests.length > 0;
        };

        scope.$watch(scope.isLoading, function (v)
        {
          if (v)
          {
            elm[0].classList.add('appLoading');
          }
          else
          {
            elm[0].classList.remove('appLoading');
          }
        });
      }
    };

    return loading;
  }]);



