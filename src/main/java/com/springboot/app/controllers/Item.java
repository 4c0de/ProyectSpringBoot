package com.springboot.app.controllers;





import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.PesoItems;
import com.springboot.app.services.ItemService;




@Controller
public class Item {
    
 //inyectamos ItemService para utilizar los metodos.   
 @Autowired
 ItemService iService;
 
 //mapeamos buscador
   @ResponseBody
  @RequestMapping(value = "/buscador",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
   //metodo que va a devolver una lista de Items de la bbdd que coincida con la busqueda
  public List<ItemModel> listar(@RequestBody ItemModel objeto) throws Exception
  {
   
       
       
    List<ItemModel> lista = iService.listaItem(objeto);

    return lista;
    
  }
   //mapeamos listado
   @ResponseBody
  @RequestMapping(value = "/listado",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
   
   //metodo que vamos a utilizar para devolver una lista completa de todos los items de la bbdd
  public List<ItemModel> listadoCompleto(@RequestBody ItemModel objeto) throws Exception
  {
       
    List<ItemModel> lista = iService.listaCompletaItem(objeto);

    return lista;      

  }
  
   
 //mapeamos listaPeso
   @ResponseBody
  @RequestMapping(value = "/listaPeso",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  
  public List<ItemModel> listadotest(@RequestBody PesoItems objeto) throws Exception
  {
       
    List<ItemModel> lista = iService.listaPeso(objeto);

    return lista;     
  }
  
   
  

  
  
  
  


}
 
