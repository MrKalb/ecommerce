/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class ProdutoDao extends AbstractDao<Produto> {
    
    public ProdutoDao(EntityManager em) {
        super(em, Produto.class);
    }
    
}
