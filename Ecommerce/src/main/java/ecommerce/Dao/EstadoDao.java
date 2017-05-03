/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Estado;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class EstadoDao extends AbstractDao<Estado> {
    
    public EstadoDao(EntityManager em) {
        super(em, Estado.class);
    }
    
}
