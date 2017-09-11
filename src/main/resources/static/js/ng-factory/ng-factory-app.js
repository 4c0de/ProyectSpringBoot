app.factory('utilFactory', function ()
{
  var servicio =
  {
    id:0,		    
    contadorBBDD: 0,
    getContadorBBDD: function ()
    {
      return this.contadorBBDD;
    },
    setContadortBBDD: function (contadorBBDD)
    {
      this.contadorBBDD = contadorBBDD;
    },
   
    getId: function()
    {
    	return this.id;
    },
    setId: function(id)
    {
    	this.id = id;
    }
};  
    return servicio;
    
});

