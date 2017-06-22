/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import ecommerce.Dao.EntregaDao;
import ecommerce.Dto.Entrega;
import ecommerce.PersistenceManager.PersistenceManager;
import ecommerce.annotations.Client;
import ecommerce.auth.Authenticator;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
@Controller
@SessionScoped
public class EntregaController implements Serializable {
    
    private final EntregaDao enDao; 
    
    @Inject
    Result result;
    
    @Inject
    private Authenticator auth;
    
    public EntregaController(){
        this.enDao= new EntregaDao(PersistenceManager.getEntityManager());
    }
    
    @Client
    @Get("/jsp/entrega/lista")
    public List<Entrega> lista(){
        this.result.include("listaList", enDao.getEntrega(this.auth.getUsuario().getCliente().getId()));
        return this.enDao.getEntrega(this.auth.getUsuario().getCliente().getId());
    }
    
    @Get("/jsp/entrega/list")
    public List<Entrega> list(){
        this.result.include("entregaList", enDao.getAll());
        return enDao.getAll();
    }
    
    public void update (Entrega entrega){
        this.enDao.startTransaction();
        Entrega en = enDao.getById(entrega);
        en.setStatus(entrega.getStatus());
        this.enDao.save(en);
        this.enDao.commitTransaction();
        this.result.redirectTo(this).list();
    }
    
    public Entrega show (Entrega entrega){
        return this.enDao.getById(entrega);
    }
    
}
