/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Cidade;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class CidadeDao extends AbstractDao<Cidade> {
    
    public CidadeDao(EntityManager em) {
        super(em, Cidade.class);
    }
    
}
