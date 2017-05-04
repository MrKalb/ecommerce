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
import ecommerce.Dao.FormaPagamentoDao;
import ecommerce.Dto.Cidade;
import ecommerce.Dto.FormaPagamento;
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
@SessionScoped
@Controller
public class PagamentoController implements Serializable {
    private final FormaPagamentoDao fpDao;
    
    private static final Logger log = LoggerFactory.getLogger(CidadeController.class);
    
    @Inject
    Result result; 
    
    public PagamentoController(){
        this.fpDao = new FormaPagamentoDao(PersistenceManager.getEntityManager());
    }
    
    @Get("/jsp/pagamento/add")
    public void add (){
          this.result.include("estadoList", this.fpDao.getAll());

    }
    
    @Get("/jsp/pagamento/show/{pagamento.id}")
    public FormaPagamento show(FormaPagamento pagamento){
        return this.fpDao.getById(pagamento);
        
    }
    
    @Post("/jsp/pagamento/add")
    public void adiciona(FormaPagamento pagamento){
        this.fpDao.startTransaction();
        this.fpDao.save(pagamento);
        this.fpDao.commitTransaction();
        result.redirectTo(this).list();
    }
    
    @Post("/jsp/pagamento/show")
    public void update(FormaPagamento pagamento){
        this.fpDao.startTransaction();
        this.result.include("pagamentoList", fpDao.getAll());
        FormaPagamento pag = fpDao.getById(pagamento);
        pag.setDescricao(pagamento.getDescricao());
        fpDao.save(pag);
        fpDao.commitTransaction();
        this.result.redirectTo(this).list();
    }
    
    @Get("/jsp/pagamento/list")
    public List<FormaPagamento> list (){
        return this.fpDao.getAll();
    }
    
    @Get("/jsp/pagamento/list/{pagamento.id}")
    public void remove(FormaPagamento pagamento){
        pagamento = fpDao.getById(pagamento);
        fpDao.startTransaction();
        fpDao.remove(pagamento);
        fpDao.commitTransaction();
        result.redirectTo(this).list();
    }
}
