/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Controller;
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
    private final CategoriaDao catDao; 
    
    private static final Logger log = LoggerFactory.getLogger(CategoriaController.class);
    
    @Inject
    Result result; 
    
    public ProdutoController(){
        this.prDao= new ProdutoDao(PersistenceManager.getEntityManager());
        this.catDao = new CategoriaDao(PersistenceManager.getEntityManager());
    }
    
        public void add(){
        this.result.include("categoriaList", this.catDao.getAll());
        this.result.include("produtoList", this.prDao.getAll());
    }
        
    public List<Produto> list (){
       return this.prDao.getAll();
    }   
     
    public void adiciona(Produto produto){
        this.prDao.startTransaction();
        this.result.include("categoriaList", this.catDao.getAll());
        this.result.include("produtoList", this.prDao.getAll());
        this.prDao.save(produto);
        this.prDao.commitTransaction();
        this.result.redirectTo(this).list();
    }

    
    public void adicionaCategoria(Produto produto, Categoria categoria[]){
        
        Produto p;
        p = prDao.getById(produto);
        
        
         p.getCategoria().addAll(Arrays.asList(categoria));
        
        
        
        
        
        Categoria cat = new Categoria();
        
       
        
    }
       
    
    
}
