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
import ecommerce.Dao.EntregaDao;
import ecommerce.Dao.FormaPagamentoDao;
import ecommerce.Dao.ItemPedidoDao;
import ecommerce.Dao.TransportadoraDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dao.VendaDao;
import ecommerce.Dto.Carrinho;
import ecommerce.Dto.Entrega;
import ecommerce.Dto.ItemPedido;
import ecommerce.Dto.Produto;
import ecommerce.Dto.Venda;
import ecommerce.PersistenceManager.PersistenceManager;
import ecommerce.annotations.Client;
import ecommerce.auth.Authenticator;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
@Controller
@RequestScoped
public class VendaController implements Serializable {

    private final VendaDao vDao;
    private final ItemPedidoDao ipDao;
    private final UsuarioDao usDao;
    private final EntregaDao etDao;
    private final ClienteDao clDao;
    private final FormaPagamentoDao fpDao;
    private final TransportadoraDao trDao;
    private final CarrinhoDao carDao;
    private float total;
    private float frete;

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
        this.etDao = new EntregaDao(PersistenceManager.getEntityManager());

    }

    private void calcula() {
        
        List<ItemPedido> ipe = clDao.getItem(auth.getUsuario().getCliente().getId());
        for (ItemPedido ip : ipe) {
            this.total += ip.getProduto().getVlrVenda() * ip.getQuantidade();
        }
        frete = (float) (total * 0.050);
        }
   
        

    @Client
    @Post("/jsp/venda/finaliza")
    public void finalizaVenda(Venda venda) {
        Date data = new Date(System.currentTimeMillis());
        Carrinho car = carDao.getCarrinho(auth.getUsuario().getCliente().getId());
        Entrega et = new Entrega();
        calcula();
        Random gerador = new Random();
        vDao.startTransaction();
        venda.setData(data);
        venda.setNumeroPedido(gerador.nextInt(99999));
        venda.setVlrFrete(frete);
        venda.setTotal(total);
        venda.setForma(fpDao.getById(venda.getForma()));
        venda.getItensVenda().addAll((clDao.getItem(auth.getUsuario().getCliente().getId())));
        venda.setTransportadora(trDao.getById(venda.getTransportadora()));
        this.vDao.save(venda);
        this.vDao.commitTransaction();
        this.carDao.startTransaction();
        car.setSts("S");
        this.carDao.save(car);
        this.carDao.commitTransaction();
        this.etDao.startTransaction();
        et.setNumeroPedido(venda.getNumeroPedido());
        et.setIdvenda(venda.getId());
        et.setTransporte(venda.getTransportadora());
        et.setCliente(auth.getUsuario().getCliente());
        et.setStatus("Aguardando Pagamento.");
        this.etDao.save(et);
        this.etDao.commitTransaction();
        this.result.redirectTo(ProdutoController.class).lista();
    }

    @Client
    @Get("/jsp/venda/list")
    public List<ItemPedido> list() {
        calcula();
        this.result.include("itemList", clDao.getItem(auth.getUsuario().getCliente().getId()));
        this.result.include("frete", frete);
        this.result.include("preco", total);
        this.result.include("total", frete + total);
        return this.clDao.getItem(auth.getUsuario().getCliente().getId());
    }

    @Client
    @Get("/jsp/venda/finaliza")
    public Carrinho finaliza() {
        calcula(); 
        this.result.include("itemList", clDao.getItem(auth.getUsuario().getCliente().getId()));
        this.result.include("transpList", this.trDao.getAll());
        this.result.include("formaList", this.fpDao.getAll());
        this.result.include("frete", frete);
        this.result.include("total", frete + total);
        return this.carDao.getCarrinho(auth.getUsuario().getCliente().getId());
    }

}
