/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.ItemPedido;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class ItemPedidoDao extends AbstractDao<ItemPedido>  {
    
    public ItemPedidoDao(EntityManager em) {
        super(em, ItemPedido.class);
    }
    
}
