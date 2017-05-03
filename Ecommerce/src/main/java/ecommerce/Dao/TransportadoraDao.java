/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Transportadora;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class TransportadoraDao extends AbstractDao<Transportadora> {
    
    public TransportadoraDao(EntityManager em) {
        super(em, Transportadora.class);
    }
    
}
