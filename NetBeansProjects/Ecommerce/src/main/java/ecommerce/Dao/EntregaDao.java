/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Entrega;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class EntregaDao extends AbstractDao<Entrega> {
    
    public EntregaDao(EntityManager em) {
        super(em, Entrega.class);
    }
    
}
