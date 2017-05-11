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
import java.util.List;
import java.util.function.Predicate;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
@Controller
@SessionScoped
public class AdicionaController implements Serializable {
    
    
           
    private final ProdutoDao prDao; 
    private final CategoriaDao catDao;  
        @Inject
    Result result; 
    
    public AdicionaController(){
        this.prDao= new ProdutoDao(PersistenceManager.getEntityManager());
        this.catDao = new CategoriaDao(PersistenceManager.getEntityManager());
    }
    
       @Post("/jsp/adiciona/add")
       public void adicionaCategoria(Integer prId, Integer ctId, Categoria categoria){
        
        this.result.include("categoriaList", this.catDao.getAll());
        this.result.include("produtoList", this.prDao.getAll());
        Produto p = null;
        Categoria c = null; 
        p.setId(prId);
        c.setId(ctId);
        
        p = prDao.getById(p);
        c = catDao.getById(c);
        p.getCategoria().add(c);
        prDao.startTransaction();
        p.getCategoria().add(c);
        prDao.commitTransaction();
        this.result.redirectTo(ProdutoController.class).list();
         //p.getCategoria().addAll(Arrays.asList(categoria));
              
        
    }
  //  @Get("/show/add/{produto.id}/{categoria.id}")
    public void removeitem(Produto produto, final Categoria categoria) {
        Produto p = this.prDao.getById(produto);
        this.prDao.startTransaction();

        p.getCategoria().removeIf(
                new Predicate<Categoria>() {

            @Override
            public boolean test(Categoria t) {
            return t.getId().equals(categoria.getId());}
        });
        this.prDao.commitTransaction();
        this.result.redirectTo(ProdutoController.class).list();
    }
    
    @Get("/jsp/produto/add/{produto.id}")
    public Produto show(Produto produto){
        return this.prDao.getById(produto);
    } 
    
    
       
}
