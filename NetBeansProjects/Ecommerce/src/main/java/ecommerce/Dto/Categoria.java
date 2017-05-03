/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author igor
 */
@Entity
public class Categoria implements AbstractDto<Integer>,Serializable {

    @Id
    @GeneratedValue
    private Integer id; 
    
    @Column
    private String descricao; 
    
    @Override
    public Integer getId() {
       return this.id; 
    }

    public Categoria( String descricao){
        this.descricao=descricao; 
    }
    
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
