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
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Table(name = "Produto")
@Entity
public class Produto implements AbstractDto<Integer>,Serializable {
    
    @Id
    @SequenceGenerator(name = "produto_id_seq", sequenceName = "produto_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "produto_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id; 
    
    @Column
    private String descricao; 
    
    @Column(name = "vlr_venda")
    private float vlrVenda; 
    
    @Column(name = "cod_barras")
    private String codBarras; 
    
    @OneToMany
        @JoinTable(
        name="tipocategoria",
      joinColumns={ @JoinColumn(name="idproduto", referencedColumnName="id") },
      inverseJoinColumns={ @JoinColumn(name="idcategoria", referencedColumnName="id", unique=true)})
    @ElementCollection
    private List<Categoria> categoria; 
    
    
    
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
    public float getVlrVenda() {
        return vlrVenda;
    }

    /**
     * @param vlrVenda the vlrVenda to set
     */
    public void setVlrVenda(float vlrVenda) {
        
        this.vlrVenda = vlrVenda;
    }

    /**
     * @return the codbarras
     */
    public String getCodBarras() {
        return codBarras;
    }

    /**
     * @param codBarras the codBarras to set
     */
    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }


    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the categoria
     */
    public List<Categoria> getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }
}
