/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author igor
 */
public class ProdutoDao extends AbstractDao<Produto> {

    private EntityManager em = getEntityManager();

    public ProdutoDao(EntityManager em) {
        super(em, Produto.class);
    }

    public List<Produto> getCategoria(String nome) {
        List<Produto> prod;
        TypedQuery<Produto> p1 = em.createQuery("SELECT p FROM Produto p join p.categoria c "+
                "where c.descricao like :name", Produto.class);
        prod = p1.setParameter("name", nome+"%").getResultList();
        return prod;
    }

}
