  
 app.controller('ng-app-controller-editar',
['$scope','$timeout','$http','$location','utilFactory', function ($scope, $timeout, $http,$location, utilFactory)
  {
	
    $http.post('editar',
    	       {
    	           id:utilFactory.getId()
    	         })
    	      
                .then(function(respuesta)
                    {
                      var data =respuesta.data;  
                      
                      //Mostrar items
                   
                     $scope.nombre=data[0].nombre;
                     $scope.categoria=data[0].categoria;
                     $scope.descripcion=data[0].descripcion;
                     $scope.url=data[0].url;
                      
                    });
    	           
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
         
       
    }; 	  
	   

  
   $scope.reset = function()
  {
     $scope.nombre = "";
     $scope.categoria = "";
     $scope.descripcion = "";
     $scope.url = "";
     
  };


}]);
