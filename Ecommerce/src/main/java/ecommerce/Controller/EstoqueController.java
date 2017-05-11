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
import com.google.gson.annotations.SerializedName;
import ecommerce.Dao.EstoqueDao;
import ecommerce.Dao.ProdutoDao;
import ecommerce.Dto.Estoque;
import ecommerce.Dto.Produto;
import ecommerce.PersistenceManager.PersistenceManager;
import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;
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
public class EstoqueController implements Serializable  {

    private final EstoqueDao estDao;
    private final ProdutoDao prdDao;

    private static final Logger log = LoggerFactory.getLogger(EstoqueController.class);

    @Inject
    Result result;

    public EstoqueController() {
        this.estDao = new EstoqueDao(PersistenceManager.getEntityManager());
        this.prdDao = new ProdutoDao(PersistenceManager.getEntityManager());
    }

    @Get("/jsp/estoque/add")
    public void add(){
        this.result.include("produtoList", this.prdDao.getAll());
    }
    
    @Get("/jsp/estoque/show/{estoque.id}")
    public Estoque show(Estoque estoque){
        this.result.include("produtoList", this.prdDao.getAll());
        return this.estDao.getById(estoque);
    }
    
    @Post("/jsp/estoque/show")
    public void updade(Estoque estoque){
        this.result.include("produtoList", this.prdDao.getAll());
        this.estDao.startTransaction();
        Estoque est = estDao.getById(estoque);
        est.setProduto(prdDao.getById(estoque.getProduto()));
        est.setQuantidade(estoque.getQuantidade());
        this.estDao.save(est);
        this.estDao.commitTransaction();
        this.result.redirectTo(this).list();        
    } 
    
    @Post("/jsp/estoque/add")
    public void adiciona(Estoque estoque) {
        this.result.include("produtoList", this.prdDao.getAll());
        this.estDao.startTransaction();
        estoque.setProduto(prdDao.getById(estoque.getProduto()));
        estDao.save(estoque);
        this.estDao.commitTransaction();
        this.result.redirectTo(this).list();
        
    }

    @Get("/jsp/estoque/list")
    public List<Estoque> list() {
        return this.estDao.getAll();
    }

    @Get("/jsp/estoque/remove/{estoque.id}")
    public void remove(Estoque estoque) {
        this.estDao.startTransaction();
        this.estDao.remove(estoque);
        this.estDao.commitTransaction();
        this.result.redirectTo(this).list();
    }

}
