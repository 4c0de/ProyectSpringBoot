app.controller('ng-app-controller-buscador',
['$scope', '$http','$timeout','$location','utilFactory', function ($scope, $http, $timeout, $location,utilFactory)
  {
    var tiempo =
    {
      buscar:
      {
        id: null,
        ms: 750
      }
    };
    
    /*
     * Funcion  marcar check  cuando click en campos formulario.
     */
    $scope.marcar = function(x) {

    	  var check=(document.querySelectorAll(".marcado"));
    	  console.log(check[x].checked);
    	  if (check[x].checked===true)
    	  {    		  
    	     check[x].checked=false;
    	    
    	  }else{
    	   check[x].checked=true;
    
    	  } 
    	};
    
    
    /*
     * FUNCION LISTADO COMPLETO ITEM AL ACCEDER AL BUSCADOR
     */
    (function()
    {
    	
        $http.post('listado',{})
        .then(function(respuesta)
            {
        	  //Almacenamos la respuesta en data.
              var data =respuesta.data;  
              //Mostrar items
              $scope.items=data;
              
          //Mostrar el numero de elementos encontrados en contador
          $scope.resultado=data.length;
            });
    })();
    

    
    
  /*
   * FUNCION AÑADIR ELEMENTOS
   */
    $scope.add = function(items)
    {
       
       utilFactory.setAdd(1);
     
       
      //$location.path("/insertar");
    	  $scope.items.push({
    	      nombre: '',
    	      categoria: '',
    	      descripcion: '',
    	      imagen:''
    	      	    
    	    });
   
 
    };
    
    
    $scope.saveadd = function(items)
    {
     var enviar=[]; 	
 
     longitud=utilFactory.getAdd();
     console.log(longitud);
  
     
     
     console.log(longitud);
     
     for (var i = longitud; i < items.length; i++)
		{	  			
		 
		  enviar.push(items[longitud]);
		 
		}
     
 	  for (var i in enviar)
		{	  			
		  console.log(enviar[i]);
		}	
      
    
 
    };
    
  /*
   *FUNCION EDITAR ELEMENTOS.
   *Recibe como parametro items de ng-repeat
   * 
   */
  
    $scope.guardar = function(items)
    {
    
//      utilFactory.setId(id);
//      $location.path("/editar");
    	
    	//creacion del array 	 
        var enviar=[];
        var forms = document.forms;
       	console.log(items);
        //recorrer los elementos del formulario
        for (var i = 0; i < forms.length; i++)
        {
      	
      	   //Si elemento checked es marcado se añade al array los item.        	
            if (forms[i].checked.checked)
			{
            	
	  			console.log("true");
	  			
	  			for (var i in items)
	  			{	  			
	  			  enviar.push(items[i]);
	  			}	
			 }	
  			
  			
  	    }
         //peticion post y envio de array 
         $http.post('editar',enviar)
         .then(function ()
          {
            //cuando editamos, para realizar una nueva petición post y mostrar la lista actualizada.  
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
 
  
    
    
    
    
    
    /*
     * FUNCION BORRAR
     */
    
    
     $scope.borrar = function()
    {
      //creacion del array 	 
      var enviar=[];
      var forms = document.forms;
      //recorrer los elementos del formulario
      for (var i = 0; i < forms.length; i++)
      {
    	 /*
    	  * Si elemento checked es marcado se añade al array el valor del input.
    	  * En este caso es el id. 
    	  */
		if (forms[i].checked.checked)
			{
				console.log("true");
				
				enviar.push({					
				    id:forms[i].checked.value				
				});
				
				console.log(forms[i].checked.value);
			
			}
	  }
       //peticion post y array 
       $http.post('borrar',enviar)
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
     * FIN FUNCION BORRAR
     */
    
  /**
   * funcion para comprobar si variable valor es un string o un numero.
   * 
   * @param {type} param---->Es igual a var valor---->Campo de busqueda en el input html del  buscador.
   * @returns {String}---->Utilizado para en $htttp.post mande a un controlador u otro.
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
	          
	          //Mostrar el numero de elementos encontrados 
	          $scope.resultado=data.length;
	          //mostrar longitud por consola
	          console.log(JSON.stringify(data.length));
	          //mostrar items
	          $scope.items = data;
	          
	           //Color blanco el contador numerico
	           colorContador.style.color="#FFFFFF";
	           
	          //Si no encontrado--> contador numerico a rojo
	          if (data.length===0){
	              colorContador.style.color="#FF0000";
	          }
             
         
        });

      }, tiempo.buscar.ms);
    };
    
  }]);