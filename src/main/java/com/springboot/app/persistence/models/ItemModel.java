package com.springboot.app.persistence.models;



/**
 *
 * @Clase ItemModel
 */
public class ItemModel {
    
    //atributos
    int id;
    String nombre;
    String descripcion;
    String url;
    String categoria;
    int contadorSql;
   



	public int getContadorSql() {
		return contadorSql;
	}

	public void setContadorSql(int contadorSql) {
		this.contadorSql = contadorSql;
	}

	public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //getters and setters 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
