/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Entrega;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author igor
 */
public class EntregaDao extends AbstractDao<Entrega> {

    private EntityManager em = getEntityManager();

    public EntregaDao(EntityManager em) {
        super(em, Entrega.class);
    }

    public List<Entrega> getEntrega(Integer a) {
        TypedQuery<Entrega> p1 = em.createQuery("SELECT en FROM Entrega en join en.cliente cl"
                + " where cl.id = :id", Entrega.class);
        return p1.setParameter("id", a).getResultList();
    }
}
