/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.auth;

import ecommerce.Dao.CarrinhoDao;
import ecommerce.Dao.ClienteDao;
import ecommerce.Dao.UsuarioDao;
import ecommerce.Dto.Carrinho;
import ecommerce.Dto.Usuario;
import ecommerce.PersistenceManager.PersistenceManager;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author igor
 */
@SessionScoped
public class CarrinhoAuth implements Serializable {

    private final CarrinhoDao carDao;
    private Carrinho carrinho;
    private final UsuarioDao usDao;
    //  private final ClienteDao clDao; 

    @Inject
    private Authenticator auth;

    public CarrinhoAuth() {
        this.carDao = new CarrinhoDao(PersistenceManager.getEntityManager());
        this.usDao = new UsuarioDao(PersistenceManager.getEntityManager());
        //   this.clDao = new ClienteDao(PersistenceManager.getEntityManager());
    }

    private void criaCarrinho() {
        carDao.startTransaction();
        Usuario usuario = usDao.getById(this.auth.getUsuario());
        carrinho = new Carrinho();
        carrinho.setCliente(usuario.getCliente());
        carDao.save(carrinho);
        carDao.commitTransaction();
    }

    public Carrinho getCarrinho(){
        if (carrinho == null) {
           criaCarrinho(); 
        }
           return carrinho; 
    }

}
