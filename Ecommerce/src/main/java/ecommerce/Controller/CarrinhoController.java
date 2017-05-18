/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import ecommerce.Dao.CarrinhoDao;
import ecommerce.Dao.ItemPedidoDao;
import ecommerce.Dao.ProdutoDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dto.Carrinho;
import ecommerce.Dto.Cliente;
import ecommerce.Dto.ItemPedido;
import ecommerce.Dto.Produto;
import ecommerce.Dto.Usuario;
import ecommerce.PersistenceManager.PersistenceManager;
import ecommerce.annotations.Administrative;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
public class CarrinhoController {

    private final ProdutoDao prDao;
    private final UsuarioDao usDao;
    private final CarrinhoDao carDao;
    private final ItemPedidoDao itDao;

    @Inject
    Result result;

    public CarrinhoController() {
        this.usDao = new UsuarioDao(PersistenceManager.getEntityManager());
        this.carDao = new CarrinhoDao(PersistenceManager.getEntityManager());
        this.itDao = new ItemPedidoDao(PersistenceManager.getEntityManager());
        this.prDao = new ProdutoDao(PersistenceManager.getEntityManager());
    }

    @Get("/jsp/produto/list/{produto.id}")
    public Produto show(Produto produto) {
        return this.prDao.getById(produto);
    }

    @Administrative
    @Post("/jsp/carrinho/add")
    public void adicionaCarrinho(Produto produto, Usuario usuario) {

        ItemPedido iP = null;
        Carrinho carrinho = null;
        Produto p = prDao.getById(produto);
        Cliente c = usDao.getById(usuario).getCliente();

        carDao.startTransaction();
        carrinho.setCliente(c);
        carDao.save(carrinho);
        carDao.commitTransaction();

        iP.setCarrinho(carrinho);
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

}
