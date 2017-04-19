/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.PieChart.Data;
import javax.persistence.Column;
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
    @ManyToOne
    @JoinTable(name = "itens_pedido", joinColumns = {
    @JoinColumn(name = "id", nullable = false, updatable = false) },
    inverseJoinColumns = { @JoinColumn(name = "idvenda",	
     nullable = false, updatable = false) })
     private Integer id; 
    
    @GeneratedValue
    @ManyToOne
        @JoinTable(name = "itens_pedido", joinColumns = {
	@JoinColumn(name = "numero_pedido", nullable = false, updatable = false) },
	inverseJoinColumns = { @JoinColumn(name = "numero_pedido",	
        nullable = false, updatable = false) })
    private Integer numeroPedido;
    
    @Column
    private Data data; 
    
    private Map<Produto,Integer> itensVenda; 
    
    @Column
    private float total; 
    
    @Column(name="idforma")
    @OneToOne
    @JoinTable(name = "formas_pagamento", joinColumns = {
    @JoinColumn(name = "id", nullable = false, updatable = false) },
    inverseJoinColumns = { @JoinColumn(name = "idformas_pagamento",	
                nullable = false, updatable = false) })
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
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * @return the total
     */
    public float getTotal() {
       this.total=0.00f;
       for(Map.Entry<Produto,Integer> item : this.itensVenda.entrySet()){
           this.total+= item.getValue() * item.getKey().getVlr_venda();
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
}
