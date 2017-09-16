package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;

public interface EditarItemService {

	
	 public int editar(List<ItemModel> lista) throws Exception; 
}
