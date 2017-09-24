package com.springboot.app.persistence.mappers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.springboot.app.persistence.models.TestModel;

@Repository
public class EditBdbbMapperImpl implements EditBdbbMapper
{
	
	@Autowired
	JdbcTemplate JdbcTemplate;

	  @Override
	  public List<Map<String, Object>> getLista(TestModel objeto) throws Exception
	  {
	    String sql = (" SELECT * " +" FROM " + objeto.getTable());
	

	    return JdbcTemplate.queryForList(sql);
	  }

}
