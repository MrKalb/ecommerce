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
import ecommerce.Dao.ClienteDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dto.Categoria;
import ecommerce.Dto.Cliente;
import ecommerce.Dto.Usuario;
import ecommerce.PersistenceManager.PersistenceManager;
import ecommerce.auth.Authenticator;
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
public class ClienteController implements Serializable {
    
    private final ClienteDao clDao; 
    private final CidadeDao cidDao;
    private final UsuarioDao uDao;
    
    private static final Logger log = LoggerFactory.getLogger(CidadeController.class);
    
    @Inject
    Result result; 
    @Inject
    private Authenticator auth;
    
    public ClienteController(){
        this.clDao = new ClienteDao(PersistenceManager.getEntityManager());
        this.cidDao = new CidadeDao(PersistenceManager.getEntityManager());
        this.uDao = new UsuarioDao(PersistenceManager.getEntityManager());
    }
    
    @Get("/jsp/cliente/add")
    public void add(){
        this.result.include("cidadeList", this.cidDao.getAll());
    }
    
    public List <Cliente> list(){
        return this.clDao.getAll();
    }
    
    @Post("/jsp/cliente/add")
    public void adiciona(Cliente cliente, Usuario usuario){
        this.result.include("cidadeList",this.cidDao.getAll());
        this.clDao.startTransaction();
        cliente.setCidade(cidDao.getById(cliente.getCidade()));
        this.clDao.save(cliente);
        this.clDao.commitTransaction();
        this.createUsuario(usuario,cliente);
        this.result.redirectTo(this).login();
        
    }
    
       
    //@Get("/jsp/cliente/show/{cliente.id}")
    public Cliente show(Cliente cliente){
        this.result.include("categoriaLista", this.clDao.getAll());
        return this.clDao.getById(cliente);
    }
    
    @Post("/jsp/cliente/update")
    public void update (Cliente cliente) throws Exception{
        this.result.include("cidadeList", cidDao.getAll());
        this.result.include("clienteList",clDao.getAll());
        Cliente c = clDao.getById(cliente);
        c.setNome(cliente.getNome());
        c.setEndereco(cliente.getEndereco());
        c.setCep(cliente.getCep());
        c.setCidade(cidDao.getById(cliente.getCidade()));
        c.setEnderecoEntrega(cliente.getEnderecoEntrega());
        c.setContato(cliente.getContato());
        c.setCpf(cliente.getCpf());
        this.clDao.save(c);
        this.clDao.commitTransaction();
        this.result.redirectTo(ProdutoController.class).list();
    }
    
    
    
    /*        @Get("/jsp/categoria/list/{categoria.id}")
    public void remove(Cliente cliente){
    cliente = clDao.getById(cliente);
    clDao.startTransaction();
    clDao.remove(cliente);
    clDao.commitTransaction();
    result.redirectTo(this).list();
    }*/
    
    
    @Post("/jsp/cliente/login")
    public void authenticate(Usuario usuario){
        
        System.out.println("Email: " + usuario.getEmail());
        
        Usuario login = this.uDao.getByEmail(usuario.getEmail());
        
        if (login!= null &&  login.getPassword().equals(usuario.getPassword()))
                this.auth.doLogin(login);
        
        else
            this.result.redirectTo(this.getClass()).login();
    }
    
    @Get("jsp/cliente/login")
    public void login(){
        
    }
    
    private void createUsuario(Usuario usuario,Cliente cliente){
        this.uDao.startTransaction();
         usuario.setCliente(clDao.getById(cliente));
        this.uDao.save(usuario);
        this.uDao.commitTransaction();
      
    }
}
