package com.springboot.app.persistence.mappers;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.PesoItems;
import com.springboot.app.utils.UtilStr;

@Repository
public class ItemMapperImpl implements ItemMapper
{

	 @Autowired
	 JdbcTemplate JdbcTemplate;



  @Override
  public List<ItemModel> ItemMapper(ItemModel objeto) throws Exception
  {
   




    /**sentencia que seleccionara nombre, categoria y descripcion que cumpla los criterios
     * de búsqueda
    */
    String sql = "SELECT * FROM items where (nombre LIKE '%" + objeto.getNombre() + "%')" +
             "OR (categoria LIKE '%" + objeto.getCategoria() + "%')"+
             "OR (descripcion LIKE '%" + objeto.getDescripcion() + "%')";
      

   
    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
  }

    @Override
    public List<ItemModel> listaCompletaItem(ItemModel objeto) throws Exception {
       
    
	    String sql = " SELECT * " +
	                 " FROM items " +
	                 " ORDER BY id DESC ";

        return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
    		  
  }
    
    @Override
    public List<ItemModel> listaPeso(PesoItems objeto)throws Exception{
        


   
    /** Sentencia que devuelve todos los campos de la tabla items en donde el id sea igual
     *  al iditem de tabla pesoitem y peso sea igual a criterio de busqueda.
     */
   
    String sql = "SELECT * FROM items where id IN"
            + "(SELECT iditem from pesoitem where peso ="+objeto.getPeso()+")";
    



    return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
        
        
        
        
        
        
    }

    @Override
    public int  borrar(ItemModel objeto) throws Exception {
         


    /**sentencia para borrar elementos de la bbdds que coincidan con el id.
    */
        
     String sql = "DELETE FROM items where id = "+objeto.getId()+"";
    // String sql = "DELETE FROM items where id IN"
     //       + "(DELETE FROM pesoitem where iditem ="+objeto.getId()+")";
    //lanzamos la consulta
   
    
 
    return JdbcTemplate.update(sql);
 

    }
    
    @Override
    public int  insertar(ItemModel objeto) throws Exception {
         

    /**sentencia para insertar  elementos  en la bbdd
    */

      String sql = "INSERT INTO items  VALUES (default,'"+objeto.getNombre()+"','"+objeto.getDescripcion()+"','"+objeto.getUrl()+"','"+objeto.getCategoria()+"')";
    
      return JdbcTemplate.update(sql);
 

    }

	@Override
	public int editar(ItemModel objeto) throws Exception {
		

	    
		String sql =" UPDATE items     " +
	            " SET nombre=     '" + objeto.getNombre() + "'" +
	            "    ,descripcion='" + objeto.getDescripcion() + "'" +
	            "    ,url=        '" + objeto.getUrl() + "'" +
	            " WHERE id=        " + objeto.getId();

	    return JdbcTemplate.update(sql);
	}
	




    
   
}