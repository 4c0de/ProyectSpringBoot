package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;

public interface BorrarItemService {
	
	
	public int borrar(List<ItemModel> lista)throws Exception;
}
