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
import ecommerce.Dao.CidadeDao;
import ecommerce.Dao.EstadoDao;
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
    private final EstadoDao estDao;
    
    private static final Logger log = LoggerFactory.getLogger(CidadeController.class);
    
    @Inject
    Result result; 
    
    public CidadeController(){
        this.cidDao = new CidadeDao(PersistenceManager.getEntityManager());
        this.estDao = new EstadoDao(PersistenceManager.getEntityManager());
    }
    
    @Get
    @Path("/")
    public void index(){
        this.result.redirectTo(this).list();
    }
    @Get("/jsp/cidade/add")
    public void add (){
          this.result.include("estadoList", this.estDao.getAll());
          this.result.include("cidadeList", this.cidDao.getAll());
    }
    
    @Get("/jsp/cidade/show/{cidade.id}")
    public Cidade show(Cidade cidade){
       this.result.include("estadoList", this.estDao.getAll());
        return this.cidDao.getById(cidade);
        
    }
    
    @Post("/jsp/cidade/add")
    public void adiciona(Cidade cidade){
        this.cidDao.startTransaction();
        cidade.setEstado(estDao.getById(cidade.getEstado()));
        this.cidDao.save(cidade);
        this.cidDao.commitTransaction();
        result.redirectTo(this).list();
    }
    
    @Post("/jsp/cidade/show")
    public void update(Cidade cidade){
        this.cidDao.startTransaction();
        this.result.include("cidadeList", cidDao.getAll());
        this.result.include("estadoList", estDao.getAll());
        Cidade cid = cidDao.getById(cidade);
        cid.setDescricao(cidade.getDescricao());
        cid.setEstado(this.estDao.getById(cidade.getEstado()));
        cidDao.save(cid);
        cidDao.commitTransaction();
        this.result.redirectTo(this).list();
    }
    
    @Get("/jsp/cidade/list")
    public List<Cidade> list (){
        return this.cidDao.getAll();
    }
    
    @Get("/jsp/cidade/list/{cidade.id}")
    public void remove(Cidade cidade){
        cidade = cidDao.getById(cidade);
        cidDao.startTransaction();
        cidDao.remove(cidade);
        cidDao.commitTransaction();
        result.redirectTo(this).list();
    }
    
}

