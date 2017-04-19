/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class ClienteDao extends AbstractDao<Cliente> {
    
    public ClienteDao(EntityManager em) {
        super(em, Cliente.class);
    }
    
}
