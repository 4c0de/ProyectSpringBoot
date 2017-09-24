package com.springboot.app.services;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.app.controllers.Test;
import com.springboot.app.persistence.models.TestModel;


public interface EditBbddService {
	
	   public List<Map<String, Object>> getLista(TestModel objeto) throws Exception;

}
