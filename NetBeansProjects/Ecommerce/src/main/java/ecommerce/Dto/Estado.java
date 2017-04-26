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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "estado")
public class Estado implements AbstractDto<Integer>,Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    
    @Column(name = "nome")
    private String descricao; 
    
    @Override
    public Integer getId() {
        return this.id; 
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
       if(descricao == null){
           throw new NullPointerException("Estado deve ter um nome");
       }
       else{
        this.descricao = descricao;
       }
       }
    
}
