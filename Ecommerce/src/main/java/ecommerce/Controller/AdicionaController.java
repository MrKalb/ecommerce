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
import ecommerce.Dao.CarrinhoDao;
import ecommerce.Dao.CategoriaDao;
import ecommerce.Dao.ItemPedidoDao;
import ecommerce.Dao.ProdutoDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dto.Carrinho;
import ecommerce.Dto.Categoria;
import ecommerce.Dto.Cliente;
import ecommerce.Dto.ItemPedido;
import ecommerce.Dto.Produto;
import ecommerce.Dto.Usuario;
import ecommerce.PersistenceManager.PersistenceManager;
import java.io.Serializable;
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
    private final UsuarioDao usDao;
    private final CarrinhoDao carDao; 
    private final ItemPedidoDao itDao;
        
    @Inject
    Result result; 
    
    public AdicionaController(){
        this.prDao= new ProdutoDao(PersistenceManager.getEntityManager());
        this.catDao = new CategoriaDao(PersistenceManager.getEntityManager());
        this.usDao = new UsuarioDao(PersistenceManager.getEntityManager());
        this.carDao = new CarrinhoDao(PersistenceManager.getEntityManager());
        this.itDao =  new ItemPedidoDao(PersistenceManager.getEntityManager());
    }
    
       @Post("/jsp/adiciona/show")
       public void adicionaCategoria(Produto produto, Categoria categoria){
        Produto prod = prDao.getById(produto);
        Categoria cat = catDao.getById(categoria);
        prDao.startTransaction();
        prod.getCategoria().add(cat);
        prDao.commitTransaction();
        this.result.redirectTo(ProdutoController.class).list();
         //p.getCategoria().addAll(Arrays.asList(categoria));
              
        
    }
    //@Get("/jsp/adiciona/list{produto.id}/{categoria.id}")
    public void removeItem(Produto produto, final Categoria categoria) {
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
    
    @Get("jsp/adiciona/lista")
    public List<Produto> lista(){
         this.result.include("listaList", this.prDao.getAll());
         return prDao.getAll();
    }
    
    @Get("/jsp/adiciona/show/{produto.id}")
    public Produto show(Produto produto){
        this.result.include("categoriaList", this.catDao.getAll());
        return this.prDao.getById(produto);
        
    } 
    @Get("/jsp/adiciona/list/")
    @Post("/jsp/adiciona/list/{tipo}")
    public List<Produto> list(String tipo){
        result.include("tipoList", prDao.getCategoria(tipo));
        return prDao.getCategoria(tipo); 
    }
   
    
       
}
