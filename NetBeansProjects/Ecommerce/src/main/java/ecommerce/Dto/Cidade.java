/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
public class Cidade implements AbstractDto<Integer>,Serializable {

    @Id
    @GeneratedValue
    private Integer id; 
    
    @Column
    @NotNull
    private String descricao; 
    
    @NotNull
    @Column(name = "idestado")
    private Estado estado; 
    
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
            throw new NullPointerException("Cidade não pode ser nula");
        }
        this.descricao = descricao;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        if(estado == null){
            throw new NullPointerException("Estado não pode ficar nulo");
        }
        this.estado = estado;
    }
    
    
    
}
