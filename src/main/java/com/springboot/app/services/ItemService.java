package com.springboot.app.services;




import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.PesoItems;

/**
 *
 * @author Lenovo
 */


 
public interface ItemService {
    
   /**
    * Obtiene una lista de items según unos criterios de busqueda.
    * @param objeto  objeto de tipo ItemModel
    * @return Lista de objetos de tipo itemModel
    * @throws Exception 
    */
    
    public List<ItemModel> listaItem(ItemModel objeto) throws Exception;
    
    /**
     * Obtiene todos los items almacenados.
     * @param objeto objeto de tipo ItemModel
     * @return Lista de objetos de tipo itemModel
     * @throws Exception 
     */

    public List<ItemModel> listaCompletaItem(ItemModel objeto)throws Exception;
    
    
       /**
    * Obtiene una lista de items según unos criterios de busqueda por peso.
    * @param objeto  objeto de tipo  PesoItems
    * @return Lista de objetos de tipo ItemModel.
    * @throws Exception 
    */
    
     public List<ItemModel> listaPeso(PesoItems objeto)throws Exception;
     
     
    

          
      
    
}
