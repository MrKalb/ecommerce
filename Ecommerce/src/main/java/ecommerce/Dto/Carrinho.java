/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "carrinho")
public class Carrinho implements AbstractDto<Integer>, Serializable {

    @Id
    @GeneratedValue
    private Integer id; 
    
    @Column(name = "idcliente")
    @NotNull
    private Cliente cliente; 
    
    @NotNull
    @OneToMany
        @JoinTable(
        name="tipocategoria",
      joinColumns={ @JoinColumn(name="idcategoria", referencedColumnName="id") },
      inverseJoinColumns={ @JoinColumn(name="idproduto", referencedColumnName="id", unique=true)})
    @ElementCollection
    private List<ItemPedido> item;  
    /* ver com o professor essa logica que ta meio estranho, teria que juntar 3 tabelas, produtos,itens_pedido e carrinho, o carrinho eu consigo
    juntar com o id e itens_pedido mas teria que juntar os produtos, dai nao sei se faço isso na tabela produto ou itens_pedido*/     
    @Override
    public Integer getId() {
        return id; 
    }

   public Carrinho(){
        this.item = new ArrayList<>();
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
     * @return the item
     */
    public List<ItemPedido> getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(List<ItemPedido> item) {
        this.item = item;
    }

    
}
