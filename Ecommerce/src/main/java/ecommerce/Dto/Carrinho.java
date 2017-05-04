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
    /*@ManyToMany
    @JoinTable(name = "itens_pedido", joinColumns = {
	@JoinColumn(name = "id", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "idcarrinho",	
                nullable = false, updatable = false) })*/
    
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
     * @return the quantidade
     */
    /*
    public Map<Produto, Integer> getQuantidade() {
        return produtos;
    }
*/
    /**
     * @param quantidade the quantidade to set
     */
    /*
    public void setQuantidade(Produto produto, Integer quantidade ) throws Exception {
        if(quantidade <= 0){
            throw new Exception("quantidade nao pode ser negativa");
        }    
        else{
            this.produtos.put(produto, quantidade); 
        }
    }
    */
    
}
