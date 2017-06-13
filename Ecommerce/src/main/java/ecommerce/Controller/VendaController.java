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
import ecommerce.Dao.FormaPagamentoDao;
import ecommerce.Dao.ItemPedidoDao;
import ecommerce.Dao.TransportadoraDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dao.VendaDao;
import ecommerce.Dto.Carrinho;
import ecommerce.Dto.ItemPedido;
import ecommerce.Dto.Venda;
import ecommerce.PersistenceManager.PersistenceManager;
import ecommerce.auth.Authenticator;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
@Controller
@RequestScoped
public class VendaController {

    private final VendaDao vDao;
    private final ItemPedidoDao ipDao;
    private final UsuarioDao usDao;
    private final ClienteDao clDao;
    private final FormaPagamentoDao fpDao;
    private final TransportadoraDao trDao;
    private final CarrinhoDao carDao;

    @Inject
    private Authenticator auth;

    @Inject
    private Result result;

    public VendaController() {
        this.vDao = new VendaDao(PersistenceManager.getEntityManager());
        this.ipDao = new ItemPedidoDao(PersistenceManager.getEntityManager());
        this.usDao = new UsuarioDao(PersistenceManager.getEntityManager());
        this.trDao = new TransportadoraDao(PersistenceManager.getEntityManager());
        this.clDao = new ClienteDao(PersistenceManager.getEntityManager());
        this.fpDao = new FormaPagamentoDao(PersistenceManager.getEntityManager());
        this.carDao = new CarrinhoDao(PersistenceManager.getEntityManager());

    }

    @Post("/jsp/venda/finaliza")
    public void finaliza(Venda venda) {
        Date data = new Date(System.currentTimeMillis());
        vDao.startTransaction();
        venda.setData(data);
        System.out.println(venda.getForma().getId());
        venda.setForma(fpDao.getById(venda.getForma()));
        venda.getItensVenda().addAll((clDao.getItem(auth.getUsuario().getCliente().getId())));
        venda.setTransportadora(trDao.getById(venda.getTransportadora()));
        this.vDao.save(venda);
        this.vDao.commitTransaction();
       // this.ipDao.startTransaction();
        //fazer foreach para setar as vendas em itempedido
        /*ItemPedido ip = null;
        ip.setVenda(venda);
        this.ipDao.save(ip);
        this.ipDao.commitTransaction();*/
        this.result.redirectTo(ProdutoController.class).list();
    }

    @Get("/jsp/venda/finaliza")
    public Carrinho finaliza() {
        this.result.include("itemList", clDao.getItem(auth.getUsuario().getCliente().getId()));
        this.result.include("transpList", this.trDao.getAll());
        this.result.include("formaList", this.fpDao.getAll());
        return this.carDao.getCarrinho(auth.getUsuario().getCliente().getId());

    }

}
