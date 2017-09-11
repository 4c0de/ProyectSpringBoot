package com.springboot.app.persistence.mappers;


import java.util.List;

import com.springboot.app.persistence.models.TestModel;


public interface TestMapper
{
  public List<TestModel> testMapper(TestModel obj) throws Exception;
}