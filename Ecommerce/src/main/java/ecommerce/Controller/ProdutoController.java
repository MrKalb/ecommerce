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
import ecommerce.Dao.CategoriaDao;
import ecommerce.Dao.ProdutoDao;
import ecommerce.Dto.Categoria;
import ecommerce.Dto.Produto;
import ecommerce.PersistenceManager.PersistenceManager;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
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
public class ProdutoController implements Serializable {
       
    private final ProdutoDao prDao;  
    
    private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);
    
    @Inject
    Result result; 
    
    public ProdutoController(){
        this.prDao= new ProdutoDao(PersistenceManager.getEntityManager());
    }
        
        @Get("/jsp/produto/add")
        public void add(){
        this.result.include("produtoList", this.prDao.getAll());
    }
    @Get("/jsp/produto/list")
    public List<Produto> list (){
       return this.prDao.getAll();
    }   
    @Post("/jsp/produto/add")
    public void adiciona(Produto produto){
        this.prDao.startTransaction();
        this.result.include("produtoList", this.prDao.getAll());
        this.prDao.save(produto);
        this.prDao.commitTransaction();
        this.result.redirectTo(this).list();
    }     
    
    @Get("/jsp/produto/show/{produto.id}")
    public Produto show(Produto produto){
        return this.prDao.getById(produto);
    } 
    
    @Post("/jsp/produto/show")
    public void update (Produto produto) throws Exception{
    this.result.include("produtoList", this.prDao.getAll());
    this.prDao.startTransaction();
    Produto pr = prDao.getById(produto);
    pr.setDescricao(produto.getDescricao());
    pr.setVlrVenda(produto.getVlrVenda());
    pr.setCodBarras(produto.getCodBarras());
    this.prDao.save(pr);
    this.prDao.commitTransaction();
    this.result.redirectTo(this).list();
    }
    
    @Get("/jsp/produto/list/{produto.id}")
    public void remove(Produto produto){
    produto = prDao.getById(produto);
    prDao.startTransaction();
    prDao.remove(produto);
    prDao.commitTransaction();
    this.result.redirectTo(this).list();
    }
        
}
