/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.PersistenceManager;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author igor
 */
public class PersistenceManager {
     private static EntityManager em;
    
    private PersistenceManager(){
    }
  public static EntityManager getEntityManager() { 
        
         
        if (PersistenceManager.em == null) {
            
            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.user", "admin");
            properties.put("javax.persistence.jdbc.password", "admin");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(
            "postgresql://localhost:5432/ecommerce", properties);
                       
            PersistenceManager.em = emf.createEntityManager();
            
        }        
        return PersistenceManager.em;    
}
}