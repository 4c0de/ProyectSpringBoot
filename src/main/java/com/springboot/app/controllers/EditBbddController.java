package com.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springboot.app.persistence.models.TestModel;
import com.springboot.app.services.EditBbddService;
import com.springboot.app.services.EditarItemService;

@Controller
public class EditBbddController {
	
	
	  @Autowired
	  EditBbddService iService;	   //mapeamos listado
	   @ResponseBody
	  @RequestMapping(value = "/listbbdd",
	                  method = RequestMethod.POST,
	                  produces = MediaType.APPLICATION_JSON_VALUE)
	   
	   //metodo que vamos a utilizar para devolver una lista completa de todos los items de la bbdd
	   public List<Map<String, Object>> getLista(@RequestBody TestModel objeto) throws Exception
	   {
	     List<Map<String, Object>> lista = iService.getLista(objeto);

	     return lista;
	   }

}
