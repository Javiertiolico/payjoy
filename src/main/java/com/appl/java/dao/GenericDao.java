/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.java.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;


/**
 * Clase generica para las operaciones de persistencia
 *
 * @author edwin
 */
public abstract class GenericDao<T extends Serializable> {

    /**
     * Instancia generica (pojo) para las consultas
     */
    private Class<T> clase;
    /**
     * crea instancia de entityManager para persistencia
     */
    @PersistenceContext
    //@Autowired
    protected EntityManager entityManager;

    /**
     * Establece el tipo de clase pojo
     *
     * @param clase pojo
     */
    public final void setClase(final Class<T> clase) {
        this.clase = clase;
    }

    /**
     * Obtiene el registro dado el id. Query: SELECT * FROM table WHERE id = ?
     *
     * @param id clave primaria
     * @return registro
     */
    public T findOne(final long id) {
        return entityManager.find(this.clase, id);
    }

    /**
     * Lista los registros de una tabla. Query: SELECT * FROM table
     *
     * @return listado
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clase.getName()).getResultList();
    }

    /**
     * Guarda el registro en la tabla. Query: INSERT INTO table VALUES(?)
     *
     * @param object Objeto a guardar
     */
    public void create(T object) {
    	final Logger logger = Logger.getLogger(getClass());
    	try {
    		entityManager.persist(object);
    		logger.info("guardado "+this.clase.getCanonicalName());
    	}catch(Exception e) {
    		//System.out.println("error al guardar en tabla. "+e.toString());
    		logger.warn("error al guardar en tabla. "+e.toString());
    	}
    }

    /**
     * Actualizar el registro en la tabla. Query: UPDATE table SET ? WHERE id=?
     *
     * @param object registro a actualizar
     * @return registro actualizado
     */
    public T merge(T object) {
        return entityManager.merge(object);
    }

    /**
     * Elimina un registro de la tabla. Query: DELETE FROM table WHERE id=?
     *
     * @param object objecto a eliminar
     */
    public void delete(T object) {
        entityManager.remove(object);
    }

    /**
     * Elimina un registro de la tabla. Query: DELETE FROM table WHERE id=?
     *
     * @param id id de tabla
     */
    public void deleteById(long id) {
        T object = findOne(id);
        delete(object);
    }
}
