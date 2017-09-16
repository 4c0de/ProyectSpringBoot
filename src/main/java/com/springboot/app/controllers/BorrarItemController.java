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
import com.springboot.app.services.BorrarItemService;


@Controller
public class BorrarItemController {
	
	 @Autowired
	BorrarItemService bService;
	 
	 //mapeamos borrar
	   @ResponseBody
	  @RequestMapping(value = "/borrar",
	                  method = RequestMethod.POST,
	                  produces = MediaType.APPLICATION_JSON_VALUE)
	  
	  public int borrar(@RequestBody List<ItemModel> lista) throws Exception
	  {
         ItemModel objeto = new ItemModel();
//		 objeto.setId(12);
//		 ItemModel objeto2 = new ItemModel();
//		 objeto2.setId(13);
//		 ItemModel objeto3 = new ItemModel();
//		 objeto3.setId(14);
//		 List<ItemModel> lista= new ArrayList<ItemModel>();
//		 lista.add(objeto);
//		 lista.add(objeto2);
//		 lista.add(objeto3);
        
		 int contador = bService.borrar(lista);
		 if(contador >0) {
			objeto.setContadorSql(contador);
			 
		 }
		
		System.out.println("Se han borrado " + objeto.getContadorSql() + " filas");
			  

       return contador;
	    

	     
	  }
}
