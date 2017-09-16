package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;

public interface InsertarItemService {
	
	   public int insertar(List<ItemModel> lista) throws Exception; 
	

}
