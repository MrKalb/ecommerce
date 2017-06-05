/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Controller;

import ecommerce.Dao.CarrinhoDao;
import ecommerce.Dao.ClienteDao;
import ecommerce.Dao.FormaPagamentoDao;
import ecommerce.Dao.ItemPedidoDao;
import ecommerce.Dao.ProdutoDao;
import ecommerce.Dao.TransportadoraDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dao.VendaDao;
import ecommerce.Dto.Venda;
import ecommerce.PersistenceManager.PersistenceManager;
import ecommerce.auth.Authenticator;
import java.util.Date;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
public class VendaController {
    
    private final VendaDao vDao; 
    private final ItemPedidoDao ipDao;
    private final UsuarioDao usDao; 
    private final ClienteDao clDao; 
    private final FormaPagamentoDao fpDao; 
    private final TransportadoraDao trDao; 
    
    @Inject
    private Authenticator auth;
    
    public VendaController(){
        this.vDao = new VendaDao(PersistenceManager.getEntityManager());
        this.ipDao = new ItemPedidoDao(PersistenceManager.getEntityManager());
        this.usDao = new UsuarioDao(PersistenceManager.getEntityManager());
        this.trDao = new TransportadoraDao(PersistenceManager.getEntityManager());
        this.clDao = new ClienteDao(PersistenceManager.getEntityManager());
        this.fpDao = new FormaPagamentoDao(PersistenceManager.getEntityManager());
        
    }
    
    public void finaliza(Venda venda){
        Date data = new Date(System.currentTimeMillis());
        vDao.startTransaction();
        venda.setData(data);
        venda.setForma(fpDao.getById(venda.getForma()));
        venda.setItensVenda(clDao.getItem(auth.getUsuario().getId()));
        venda.setTransportadora(trDao.getById(venda.getTransportadora()));
        this.vDao.save(venda);
        this.vDao.commitTransaction();
    }
    
}
