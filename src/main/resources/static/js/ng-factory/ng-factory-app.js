app.factory('utilFactory', function ()
{
  var servicio =
  {
    id:0,	
    add:0,
    contadorBBDD: 0,
    bbdd:'',
    getContadorBBDD: function ()
    {
      return this.contadorBBDD;
    },
    setContadortBBDD: function (contadorBBDD)
    {
      this.contadorBBDD = contadorBBDD;
    },
    getbbdd: function()
    {
    	return this.bbdd;
    },
    setbbdd: function(bbdd)
    {
    	this.bbdd = bbdd;
    },
    
    getId: function()
    {
    	return this.id;
    },
    setId: function(id)
    {
    	this.id = id;
    },
    getAdd: function()
    {
    	return this.add;
    },
    setAdd: function(add)
    {
    	this.add =+ add;
    }
};  
    return servicio;
    
});

