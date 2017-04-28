/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import ecommerce.Dao.CidadeDao;
import ecommerce.Dto.Cidade;
import ecommerce.PersistenceManager.PersistenceManager;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author igor
 */
@Controller
@SessionScoped
public class CidadeController implements Serializable {
    
    private final CidadeDao cidDao;
    
    private static final Logger log = LoggerFactory.getLogger(CidadeController.class);
    
    @Inject
    Result result; 
    
    public CidadeController(){
        this.cidDao = new CidadeDao(PersistenceManager.getEntityManager());
    }
    
    @Get
    @Path("/")
    public void index(){
        this.result.redirectTo(CidadeController.class).list();
    }
    
    public void add (){
          result.include("cidadeList", this.cidDao.getAll());
    }
    
    public void adiciona(Cidade cidade){
        this.cidDao.startTransaction();
        this.cidDao.save(cidade);
        this.cidDao.commitTransaction();
        result.redirectTo(CidadeController.class).list();
    }
    
    public List<Cidade> list (){
        return this.cidDao.getAll();
    }
    
    
    
}

