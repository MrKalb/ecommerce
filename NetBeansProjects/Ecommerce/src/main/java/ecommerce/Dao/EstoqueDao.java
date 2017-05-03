/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Estoque;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class EstoqueDao extends AbstractDao<Estoque> {
    
    public EstoqueDao(EntityManager em) {
        super(em, Estoque.class);
    }
    
}
