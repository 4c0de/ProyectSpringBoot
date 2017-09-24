package com.springboot.app.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.app.controllers.Test;
import com.springboot.app.persistence.mappers.EditBdbbMapper;
import com.springboot.app.persistence.mappers.ItemMapper;
import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;

@Service
public class EditBdddServiceImpl implements EditBbddService{
	
	 @Autowired 
     EditBdbbMapper iMapper;

	   public List<Map<String, Object>> getLista(TestModel objeto) throws Exception
	   {
	     List<Map<String, Object>> lista = iMapper.getLista(objeto);

	     return lista;
	   }


}
