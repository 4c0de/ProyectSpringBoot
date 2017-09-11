app.controller('ng-app-controller-buscador',
['$scope', '$http','$timeout', '$location', function ($scope, $http, $timeout, $location)
  {
    var tiempo =
    {
      buscar:
      {
        id: null,
        ms: 750
      }
    };
    
   
    
    //funcion  para que salga el listado completo de los item al acceder al buscador.
    (function()
    {
        $http.post('listado',{})
        .then(function(respuesta)
            {
              var data =respuesta.data;  
              //Mostrar items
              $scope.items=data;
              
          //para mostrar el numero de elementos encontrados en contador
          $scope.resultado=data.length;
            });
    })();
    
     //funcion añadir  elementos
    $scope.add = function()
    {
      $location.path("/insertar");
 
    };
    
    //funcion borrar elemento
    $scope.borrar = function(elemento)
    {
      
       $http.post('borrar',
       {
           id:elemento
         })
       .then(function ()
        {
          //cuando borramos para realizar una nueva petición post y mostrar la lista actualizada.  
          $http.post('listado',{})
                .then(function(respuesta)
                    {
                      var data =respuesta.data;  
                      //Mostrar items
                      $scope.items=data;
                      //para mostrar el numero de elementos encontrados en contador
                       $scope.resultado=data.length;
                    });
           
        }); 
     
 
    };  
    
  /**
   * funcion que vamos a usar para comprobar si variable valor es un string o un numero.
   * 
   * @param {type} param---->Es igual a var valor---->osease campo de busqueda en el input html del  buscador.
   * @returns {String}---->Lo hemos utilizado para en $htttp.post mande a un controlador u otro.
   */
  
    function isPeso(param)
    {
        return isNaN(param)?'/buscador':'/listaPeso';
    }
    
  
     
    $scope.busqueda = function (e)
    {
      var valor = e.target.value;
      var colorContador =document.querySelector('#resultado');
      
      $timeout.cancel(tiempo.buscar.id);
      tiempo.buscar.id = $timeout(function ()
      {
        //peticion post a mapping que redireccionará a un lado u otro segun la funcion isPeso.
        $http.post(isPeso(valor),
        {
          //propiedades que le mandamos al back  
          nombre: valor,
          categoria: valor,
          descripcion:valor,
          peso:valor
          
        
        })
        .then(function (respuesta)
        {
          var data = respuesta.data;
          
          //para mostrar el numero de elementos encontrados 
          $scope.resultado=data.length;
          //mostramos longitud por consola
          console.log(JSON.stringify(data.length));
          //mostrar items
          $scope.items = data;
          
           //ponemos a blanco el contador numerico
           colorContador.style.color="#FFFFFF";
          //Si no encontrado ponemos el contador numerico a rojo
          if (data.length===0){
              colorContador.style.color="#FF0000";
          }
             
         
        });

      }, tiempo.buscar.ms);
    };
    
  }]);