/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.FormaPagamento;
import javax.persistence.EntityManager;

/**
 *
 * @author igor
 */
public class FormaPagamentoDao extends AbstractDao<FormaPagamento> {
    
    public FormaPagamentoDao(EntityManager em) {
        super(em, FormaPagamento.class);
    }
    
}
