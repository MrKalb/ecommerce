/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.AbstractDto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



/**
 *
 * @author igor
 */
public abstract class AbstractDao <T extends Serializable & AbstractDto> {
    
    private EntityManager em; // gerenciado de EntityManager
    private Class entityClass; // Classe a que se refere 
    private static  Logger log = LoggerFactory.getLogger(AbstractDao.class.getName());
    
    public AbstractDao(EntityManager em, Class entityName){
        this.em = em;
        this.entityClass = entityName;
    }
    
    public void startTransaction(){
        if (!this.em.getTransaction().isActive())
            this.em.getTransaction().begin();
    }
    
    public void commitTransaction(){
        if (this.em.getTransaction().isActive())
            this.em.getTransaction().commit();
    }
    
    
    
    public void save (T object){        
        this.em.persist(object);
    }
    
    public T update (T object){
        return this.em.merge(object);
    }
    
    public void remove(T object){         
         this.em.remove(this.em.contains(object)? object : (T) this.em.find(object.getClass(), object.getId()));
    }
    
    public List<T> getAll(){
        
  
        TypedQuery<T> ret = 
                (TypedQuery<T>) this.em.createQuery("SELECT T from " + 
                      this.entityClass.getSimpleName()  + " T ",  this.entityClass);
        
        return ret.getResultList();
    }
    
    public T getById(T object){
       
        return (T) this.em.find(object.getClass(), object.getId());

    }
    
    
    public EntityManager getEntityManager(){
        return this.em;
    }
    
}
