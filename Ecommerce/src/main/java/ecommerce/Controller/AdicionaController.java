/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import ecommerce.Dao.CategoriaDao;
import ecommerce.Dao.ProdutoDao;
import ecommerce.Dto.Categoria;
import ecommerce.Dto.Produto;
import ecommerce.PersistenceManager.PersistenceManager;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
public class AdicionaController {
    
    
           
    private final ProdutoDao prDao; 
    private final CategoriaDao catDao;  
        @Inject
    Result result; 
    
    public AdicionaController(){
        this.prDao= new ProdutoDao(PersistenceManager.getEntityManager());
        this.catDao = new CategoriaDao(PersistenceManager.getEntityManager());
    }
    
    
       public void adicionaCategoria(Produto produto, Categoria categoria[]){
        
        this.result.include("categoriaList", this.catDao.getAll());
        this.result.include("produtoList", this.prDao.getAll());
           
           Produto p;
          
        p = prDao.getById(produto);
        
        
         p.getCategoria().addAll(Arrays.asList(categoria));
              
        
    }
    @Get("/show/purgeItemShow/{show.id}/{itemShow.id}")
    public void purgeItemShow(Produto produto, final Categoria categoria) {
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
    
       
}
