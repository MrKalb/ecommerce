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
import ecommerce.Dto.Categoria;
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
public class CategoriaController implements Serializable {
    
    private final CategoriaDao catDao; 
    
    
    private static final Logger log = LoggerFactory.getLogger(CidadeController.class);
    
    @Inject
    Result result; 
    
    public CategoriaController(){
        this.catDao = new CategoriaDao(PersistenceManager.getEntityManager());
    }
    
    public void index (){
        this.result.redirectTo(this).list();
    }
    @Get("/jsp/categoria/add")
    public void add(){
        this.result.include("categoriaList", this.catDao.getAll());
    }
    @Post("/jsp/categoria/add")
    public void adiciona(Categoria categoria){
        this.catDao.startTransaction();
        this.catDao.save(categoria);
        this.catDao.commitTransaction();
        this.result.redirectTo(this).list();
    }
    
    @Get("/jsp/categoria/list")
    public List<Categoria> list(){
        return this.catDao.getAll();
    }
    
    @Get("/jsp/categoria/show/{categoria.id}")
    public Categoria show(Categoria categoria){
        this.result.include("categoriaLista", this.catDao.getAll());
         return this.catDao.getById(categoria);
    }
    
    @Post("/jsp/categoria/show")
    public void update (Categoria categoria){
        this.catDao.startTransaction();
        this.result.include("categoriaList", this.catDao.getAll());
        Categoria cat = this.catDao.getById(categoria);
        cat.setDescricao(categoria.getDescricao());
        this.catDao.save(cat);
        this.catDao.commitTransaction();
        this.result.redirectTo(this).list();
    }
        @Get("/jsp/categoria/list/{categoria.id}")
        public void remove(Categoria categoria){
        categoria = catDao.getById(categoria);
        catDao.startTransaction();
        catDao.remove(categoria);
        catDao.commitTransaction();
        result.redirectTo(this).list();
    }
}
