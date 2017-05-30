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
import ecommerce.Dao.ClienteDao;
import ecommerce.Dao.ItemPedidoDao;
import ecommerce.Dao.ProdutoDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dto.Carrinho;
import ecommerce.Dto.Categoria;
import ecommerce.Dto.ItemPedido;
import ecommerce.Dto.Produto;
import ecommerce.Dto.Usuario;
import ecommerce.PersistenceManager.PersistenceManager;
import ecommerce.annotations.Administrative;
import ecommerce.auth.Authenticator;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

/**
 *
 * @author igor
 */
@Controller
@SessionScoped
public class CarrinhoController implements Serializable {

    private final ProdutoDao prDao;
    private final UsuarioDao usDao;
    private final ClienteDao clDao;
    private final CarrinhoDao carDao;
    private final ItemPedidoDao itDao;

    @Inject
    private Authenticator auth;

    @Inject
    Result result;

    public CarrinhoController() {
        this.usDao = new UsuarioDao(PersistenceManager.getEntityManager());
        this.carDao = new CarrinhoDao(PersistenceManager.getEntityManager());
        this.itDao = new ItemPedidoDao(PersistenceManager.getEntityManager());
        this.prDao = new ProdutoDao(PersistenceManager.getEntityManager());
        this.clDao = new ClienteDao(PersistenceManager.getEntityManager());
    }

    @Get("/jsp/carrinho/list/{usuario.id}")
    public List<ItemPedido> list(Usuario usuario) {
        usuario = usDao.getById(this.auth.getUsuario());
        return clDao.getCarrinho(usuario.getCliente().getId());
    }

    @Administrative
    @Post("/jsp/carrinho/show")
    public void adicionaCarrinho(Produto produto, Carrinho carrinho,Integer quantidade) {

        ItemPedido iP = null;
        Produto p = prDao.getById(produto);
        Usuario usuario = usDao.getById(this.auth.getUsuario());
        carDao.startTransaction();
        carrinho.setCliente(usuario.getCliente());
        carDao.save(carrinho);
        carDao.commitTransaction();

        iP.setCarrinho(carrinho);
        iP.setQuantidade(quantidade);
        iP.setProduto(p);
        itDao.startTransaction();
        itDao.save(iP);
        itDao.commitTransaction();

        this.result.redirectTo(ProdutoController.class).list();
    }

    @Get("/jsp/produto/list/{produto.id}")
    public void remove(ItemPedido item, Carrinho carrinho) {
        item = itDao.getById(item);
        itDao.startTransaction();
        itDao.remove(item);
        itDao.commitTransaction();
        carDao.startTransaction();
        carDao.remove(carrinho);
        carDao.commitTransaction();
        //this.result.redirectTo(this).list();
    }
    @Administrative
    @Get("/jsp/carrinho/show/{produto.id}")
    public Produto show(Produto produto) {
        return this.prDao.getById(produto);
    }

}
