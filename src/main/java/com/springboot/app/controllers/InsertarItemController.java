package com.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;
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
	  
	  public int editar(@RequestBody List<ItemModel> lista) throws Exception
	  {

		     ItemModel objeto = new ItemModel();	 			 
			 int contador =iService.insertar(lista);
			 if(contador >0) {
				objeto.setContadorSql(contador);
				 
			 }
			
			System.out.println("Se han insertado " + objeto.getContadorSql() + " filas");
		  
	
		  return contador; 
	  }

}
