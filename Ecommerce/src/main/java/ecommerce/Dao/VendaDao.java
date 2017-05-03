/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Venda;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class VendaDao extends AbstractDao<Venda> {
    
    public VendaDao(EntityManager em) {
        super(em, Venda.class);
    }
    
}
