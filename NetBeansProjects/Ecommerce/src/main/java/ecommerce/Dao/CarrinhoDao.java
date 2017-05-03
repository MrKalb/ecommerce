/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Carrinho;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class CarrinhoDao extends AbstractDao<Carrinho> {
    
    public CarrinhoDao(EntityManager em) {
        super(em, Carrinho.class);
    }
    
}
