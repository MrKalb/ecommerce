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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "carrinho")
@DynamicUpdate
public class Carrinho implements AbstractDto<Integer>, Serializable {

    @Id
    @SequenceGenerator(name = "carrinho_id_seq", sequenceName = "carrinho_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "carrinho_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id; 
    
    @JoinColumn(name = "idcliente")
    @OneToOne
    private Cliente cliente; 
    
    @Column(name = "flgvenda")
    private String sts; 
    
  /*  @NotNull
    @OneToMany
        @JoinTable(
        name="tipocategoria",
      joinColumns={ @JoinColumn(name="idcategoria", referencedColumnName="id") },
      inverseJoinColumns={ @JoinColumn(name="idproduto", referencedColumnName="id", unique=true)})
    
    
    @ElementCollection
    private List<ItemPedido> item;  
    */
    
    @Override
    public Integer getId() {
        return id; 
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the sts
     */
    public String getSts() {
        return sts;
    }

    /**
     * @param sts the sts to set
     */
    public void setSts(String sts) {
        this.sts = sts;
    }
}
