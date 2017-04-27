/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import ecommerce.Dao.EstadoDao;
import ecommerce.Dto.Estado;
import ecommerce.PersistenceManager.PersistenceManager;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author igor
 */
@Controller
@RequestScoped
public class EstadoController {
    
    private final EstadoDao estDao;
    
    private static final Logger log = LoggerFactory.getLogger(EstadoController.class);
    
    @Inject
    Result result;
    
    public EstadoController(){
        this.estDao = new EstadoDao(PersistenceManager.getEntityManager());
    }
    
    @Get
    @Path("/")
    public void index(){
        this.result.redirectTo(EstadoController.class).list();
    }
    
    @Get
    @Path("/jsp/estado/add")
    public void add(){
        this.result.include("estadoList", this.estDao.getAll());
    }
    
    
    @Post("/jsp/estado/show")
    public void update (Estado estado){
        this.estDao.startTransaction();
        this.result.include("cidadeList", this.estDao.getAll());
        Estado est = this.estDao.getById(estado);
        est.setDescricao(est.getDescricao());
        this.estDao.save(est);
        this.estDao.commitTransaction();
        result.redirectTo(EstadoController.class).list();
    }
    
    
    @Get("/jsp/estado/list")
    public List<Estado> list(){
        
        return this.estDao.getAll();
    }
    @Post("/jsp/estado/add")
    public void adiciona(Estado estado){
        this.estDao.startTransaction();
        this.estDao.save(estado);
        this.estDao.commitTransaction();
        result.redirectTo(EstadoController.class).list();
    }
    
    
    @Get("/jsp/estado/list/{estado.id}")
    public void remove(Estado estado){
        this.estDao.startTransaction();
        this.estDao.remove(estado);
        this.estDao.commitTransaction();
        this.result.redirectTo(EstadoController.class).list();
        this.result.include("mensagem", "estado deletado com sucesso");
    }
    
}
