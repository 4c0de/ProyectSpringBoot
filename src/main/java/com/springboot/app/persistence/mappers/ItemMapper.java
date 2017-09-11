package com.springboot.app.persistence.mappers;




import java.util.List;

import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.PesoItems;


  /**
   * Metodo que devuelve todos los elementos almacenados en la bbdd basado en la busqueda.
   *
   * @param objeto Objeto tipo ItemModel.
   *
   * @return Lista de objetos tipo ItemModel.
   */

public interface ItemMapper {
    
    public List<ItemModel> ItemMapper(ItemModel objeto) throws Exception;
    
    
   /**
   * Devuelve todos los elementos almacenados en la bbdd.
   *
   * @param objeto Objeto tipo ItemModel.
   *
   * @return Lista de objetos tipo ItemModel.
   */

    public List<ItemModel> listaCompletaItem(ItemModel objeto) throws Exception;
    
    
/**
 * Devuelve una lista de elementos según unos criterios de busqueda basado en peso.
 * @param objeto Objeto de tipo Pesoitems
 * @return Lista de objetos de tipo ItemModel.
 * @throws Exception 
 */
    
    public List<ItemModel> listaPeso(PesoItems objeto)throws Exception;
    
    public void borrar(ItemModel objeto)throws Exception;
     
    public void insertar(ItemModel objeto) throws Exception;
 
   

    
    

}




