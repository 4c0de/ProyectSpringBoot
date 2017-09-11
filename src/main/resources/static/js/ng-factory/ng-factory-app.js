app.factory('utilFactory', function ()
{
  var servicio =
  {
    contadorBBDD: 0,
    getContadorBBDD: function ()
    {
      return this.contadorBBDD;
    },
    setContadortBBDD: function (contadorBBDD)
    {
      this.contadorBBDD = contadorBBDD;
    }
};  
    return servicio;
    
});

