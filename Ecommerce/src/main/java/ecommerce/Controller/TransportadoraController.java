/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import ecommerce.Dao.CidadeDao;
import ecommerce.Dao.TransportadoraDao;
import ecommerce.Dto.Cidade;
import ecommerce.Dto.Transportadora;
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
public class TransportadoraController implements Serializable {
    
    private final CidadeDao cidDao;
    private final TransportadoraDao trDao;
    
    private static final Logger log = LoggerFactory.getLogger(TransportadoraController.class);
    
    @Inject
    Result result;
    
    public TransportadoraController(){
        this.trDao= new TransportadoraDao(PersistenceManager.getEntityManager());
        this.cidDao = new CidadeDao(PersistenceManager.getEntityManager());    
    }
        @Get("/jsp/transportadora/add")
        public void add (){
          this.result.include("cidadeList", this.cidDao.getAll());
          this.result.include("transportadoraList", this.trDao.getAll());
        }
        
        @Get("/jsp/transportadora/show/{transportadora.id}")
        public Transportadora show(Transportadora transportadora){
        this.result.include("cidadeList", this.cidDao.getAll());
        this.result.include("transportadoraList", this.trDao.getAll());
        return this.trDao.getById(transportadora);
    }
        @Post("/jsp/transportadora/add")
        public void adiciona(Transportadora transportadora){
            this.trDao.startTransaction();
            transportadora.setCidade(cidDao.getById(transportadora.getCidade()));
            this.trDao.save(transportadora);
            this.trDao.commitTransaction();
            this.result.redirectTo(this).list();  
        }
        @Get("/jsp/transportadora/list")
        public List<Transportadora> list(){
            return this.trDao.getAll();
        }
        
        @Post("/jsp/transportadora/show")
        public void update(Transportadora transportadora) throws Exception{
        this.trDao.startTransaction();
        Transportadora tr = this.trDao.getById(transportadora);
        this.result.include("cidadeList", cidDao.getAll());
        this.result.include("transportadoraList", trDao.getAll());
        tr.setRazao(transportadora.getRazao());
        tr.setFantasia(transportadora.getRazao());
        tr.setEndereco(transportadora.getEndereco());
        tr.setCnpj(transportadora.getCnpj());
        tr.setCidade(this.cidDao.getById(transportadora.getCidade()));
        this.trDao.save(tr);
        this.trDao.commitTransaction();
        this.result.redirectTo(this).list();
        }
        
        @Get("/jsp/transportadora/list/{transportadora.id}")
        public void remove(Transportadora transportadora){
            transportadora = trDao.getById(transportadora);
            this.trDao.startTransaction();
            this.trDao.remove(transportadora);
            this.trDao.commitTransaction();
            this.result.redirectTo(this).list();
            
        }
}
