package com.springboot.app.persistence.mappers;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;

public interface EditBdbbMapper {
	
	public List<Map<String, Object>> getLista(TestModel objeto) throws Exception;


}
