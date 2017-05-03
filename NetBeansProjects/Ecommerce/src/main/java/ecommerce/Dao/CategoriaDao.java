/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Categoria;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class CategoriaDao extends AbstractDao<Categoria>{
    
    public CategoriaDao(EntityManager em) {
        super(em, Categoria.class);
    }
    
}
