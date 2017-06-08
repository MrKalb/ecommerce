/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Carrinho;
import ecommerce.Dto.Cliente;
import ecommerce.Dto.ItemPedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author igor
 */
public class CarrinhoDao extends AbstractDao<Carrinho> {

    private EntityManager em = getEntityManager();
    
    public CarrinhoDao(EntityManager em) {
        super(em, Carrinho.class);
    }

    public Carrinho getCarrinho(Integer a) {
        TypedQuery<Carrinho> p1 = em.createQuery("select c from Carrinho c join Cliente cl on c.cliente.id = cl.id"
                + "where c.cliente.id = :id and flgvenda <> 'S'",Carrinho.class);
         return p1.setParameter("id", a).getSingleResult();
    }

}
