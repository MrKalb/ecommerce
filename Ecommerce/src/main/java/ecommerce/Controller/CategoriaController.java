/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Controller;
import ecommerce.Dao.CategoriaDao;
import ecommerce.PersistenceManager.PersistenceManager;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author igor
 */
@Controller
@SessionScoped
public class CategoriaController implements Serializable {
    
    private final CategoriaDao catDao; 
    
    public CategoriaController(){
        catDao = new CategoriaDao(PersistenceManager.getEntityManager());
    }
}
