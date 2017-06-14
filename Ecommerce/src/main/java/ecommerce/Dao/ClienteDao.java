/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Cliente;
import ecommerce.Dto.ItemPedido;
import ecommerce.Dto.Produto;
import java.util.List;
import static javafx.scene.input.KeyCode.T;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author igor
 */
public class ClienteDao extends AbstractDao<Cliente> {
    
     private EntityManager em = getEntityManager();
    
    public ClienteDao(EntityManager em) {
        super(em, Cliente.class);
    }
    
        public List<ItemPedido> getItem(Integer a){
            List<ItemPedido> ped; 
          TypedQuery<ItemPedido> p1 = em.createQuery("SELECT ip FROM ItemPedido ip join ip.carrinho ca "
                  + " where ca.cliente.id = :id and ca.sts is null",ItemPedido.class);
          ped = p1.setParameter("id", a).getResultList();
          return ped; 
    }
    
    
}
