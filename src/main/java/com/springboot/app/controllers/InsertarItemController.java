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
import com.springboot.app.services.InsertarItemService;


@Controller
public class InsertarItemController {
	 @Autowired
	 InsertarItemService iService;
	  
	  //mapeamos insertar
	  @ResponseBody
	  @RequestMapping(value = "/insertar",
	                  method = RequestMethod.POST,
	                  produces = MediaType.APPLICATION_JSON_VALUE)
	  
	  public int insertar(@RequestBody ItemModel object) throws Exception
	  {
		     ItemModel objeto = new ItemModel();
			 objeto.setNombre("hola objeto1");
			 objeto.setDescripcion("hola descripcion1");
			 objeto.setUrl("url1");
			 ItemModel objeto2 = new ItemModel();
			 objeto2.setNombre("hola objeto2");
			 objeto2.setDescripcion("hola depcrion 2");
			 objeto2.setUrl("url2");
			 ItemModel objeto3 = new ItemModel();
			 objeto3.setNombre("hola objeto2");
			 objeto3.setDescripcion("hola depcrion 2");
			 objeto3.setUrl("url2");
			 List<ItemModel> lista= new ArrayList<ItemModel>();
			 lista.add(objeto);
			 lista.add(objeto2);
			 lista.add(objeto3);
			 
			 int contador = iService.insertar(lista);
			 if(contador >0) {
				objeto.setContadorSql(contador);
				 
			 }
			
			System.out.println("Se han insertado " + objeto.getContadorSql() + " filas");
		  

		  return contador;
	  }

}
