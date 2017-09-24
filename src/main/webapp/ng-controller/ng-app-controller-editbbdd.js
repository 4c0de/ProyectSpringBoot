
  
  app.controller('ng-app-controller-editbbdd',
		  ['$scope', '$http', '$timeout', 'utilFactory',
			  function ($scope, $http, $timeout, utilFactory)
			  {

			    (function ()
			    {
			      $http.post('/test',
			      {
			    	  tabla:'valor'
			      })
			      .then(function (response)
			      {
			        var data = response.data;
			        $scope.bbdd = data;
			      });
			    })();


			    $scope.select = function (tabla)
			    {			     
        
			        $http.post('/listbbdd',
			        {
			          table: tabla
			        })
			        .then(function (response)
			        {
			          var data = response.data;
			          console.log(data);
			          $scope.items = data;
			        });
			      }
			 




			  }]);