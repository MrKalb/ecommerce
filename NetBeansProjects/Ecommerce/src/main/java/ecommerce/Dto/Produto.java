/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author igor
 */
@Table(name = "Produto")
@Entity
public class Produto implements AbstractDto<Integer>,Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    
    @Column
    private String descricao; 
    
    @Column
    private float vlr_venda; 
    
    @Column
    private String codbarras; 
    
    //@ManyToMany
        //@JoinTable(name = "tipocategoria", joinColumns = {
	//@JoinColumn(name = "id", nullable = false, updatable = false) },
	//inverseJoinColumns = { @JoinColumn(name = "idcategoria",	
         //       nullable = false, updatable = false) })
    private Integer categoria; 
    
    public Produto(){
    }
    
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
    public void setDescricao(String descricao) throws Exception {
        if(descricao == null){
            throw new NullPointerException("Produto deve ter uma descricao"); 
        }
        else{
            this.descricao = descricao;
        }
    }

    /**
     * @return the vlr_venda
     */
    public float getVlr_venda() {
        return vlr_venda;
    }

    /**
     * @param vlr_venda the vlr_venda to set
     */
    public void setVlr_venda(float vlr_venda) throws Exception {
        if(vlr_venda <= 0){
            throw new Exception("Produto não pode ter valor negativo ou zerado");
        }
        
        this.vlr_venda = vlr_venda;
    }

    /**
     * @return the codbarras
     */
    public String getCodbarras() {
        return codbarras;
    }

    /**
     * @param codbarras the codbarras to set
     */
    public void setCodbarras(String codbarras) {
        this.codbarras = codbarras;
    }
    
    
    
}
