package com.springboot.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.persistence.mappers.ItemMapper;
import com.springboot.app.persistence.models.ItemModel;

@Service
public class InsertarItemServiceImpl implements InsertarItemService {
	
	  @Autowired 
	  ItemMapper iMapper;
	
    @Override
    public int insertar(List<ItemModel> lista) throws Exception {
      
    	 int contador=0;
    	 for (ItemModel objeto: lista) {
    		 int x=iMapper.insertar(objeto);
    		 contador +=x;
    	 }
    	
    return contador;   
    }


}
