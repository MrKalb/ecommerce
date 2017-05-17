/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.chart.PieChart.Data;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author igor
 */
@Entity
public class Venda implements AbstractDto<Integer>,Serializable {

    @Id
    @GeneratedValue
     private Integer id; 
    
    @GeneratedValue
    private Integer numeroPedido;
    
    @Column
    private String data; 
    
    @ElementCollection
    private List<ItemPedido> itensVenda; 
    
    
    @Column
    private float total; 
    
    @OneToOne
    private FormaPagamento forma; 
    
    @Column 
    private float vlrFrete; 
    

    @Override
    public Integer getId() {
        return id; 
    }

    /**
     * @return the numeroPedido
     */
    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    /**
     * @param numeroPedido the numeroPedido to set
     */
    public void setNumeroPedido(Integer numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the total
     */
    public float getTotal() {
       this.total=0.00f;
       for(ItemPedido ip : this.getItensVenda()){
           this.total+= ip.getProduto().getVlrVenda() * ip.getQuantidade();
           
       }
        total+=vlrFrete; 
       
        return total;
    }

    /**
     * @return the forma
     */
    public FormaPagamento getForma() {
        return forma;
    }

    /**
     * @param forma the forma to set
     */
    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }

    /**
     * @return the itensVenda
     */
    public List<ItemPedido> getItensVenda() {
        return itensVenda;
    }
}
