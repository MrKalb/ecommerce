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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "Categoria")
public class Categoria implements AbstractDto<Integer>,Serializable {

    @Id
    @SequenceGenerator(name = "categoria_id_seq", sequenceName = "categoria_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "categoria_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id; 
    
    @Column(name = "descricao")
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
        this.descricao = descricao;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
