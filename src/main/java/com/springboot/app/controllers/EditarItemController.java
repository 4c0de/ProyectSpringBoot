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
import com.springboot.app.services.EditarItemService;

@Controller
public class EditarItemController {

	  @Autowired
	  EditarItemService eService;
	  //mapeamos editar
	  @ResponseBody
	  @RequestMapping(value = "/editar",
	                  method = RequestMethod.POST,
	                  produces = MediaType.APPLICATION_JSON_VALUE)
	  
	  public int editar(@RequestBody List<ItemModel> lista) throws Exception
	  {

		     ItemModel objeto = new ItemModel();
//		     objeto.setId(15);
//			 objeto.setNombre("hola objeto1editar");
//			 objeto.setDescripcion("hola descripcion1");
//			 objeto.setUrl("url1");
//			 ItemModel objeto2 = new ItemModel();
//			 objeto2.setId(16);
//			 objeto2.setNombre("hola objeto2editar");
//			 objeto2.setDescripcion("hola depcrion 2");
//			 objeto2.setUrl("url2");
//			
//			 List<ItemModel> lista= new ArrayList<ItemModel>();
//			 lista.add(objeto);
//			 lista.add(objeto2);
//			 			 
			 int contador =eService.editar(lista);
			 if(contador >0) {
				objeto.setContadorSql(contador);
				 
			 }
			
			System.out.println("Se han editado " + objeto.getContadorSql() + " filas");
		  
	
		  return contador; 
	  }

	
	
}
