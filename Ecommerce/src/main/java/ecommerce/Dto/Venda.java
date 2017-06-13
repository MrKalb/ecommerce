/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author igor
 */
@Entity
public class Venda implements AbstractDto<Integer>, Serializable {

    @Id
    @SequenceGenerator(name = "venda_id_seq", sequenceName = "venda_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_id_seq")
    @Column(name = "id", columnDefinition = "serial")
    private Integer id;

    @SequenceGenerator(name = "venda_numero_pedido_id_seq", sequenceName = "venda_numero_pedido_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda_numero_pedido_id_seq")
    @Column(name = "numero_pedido", columnDefinition = "serial")
    private Integer numeroPedido;

    @Temporal(TemporalType.DATE)
    @Column
    private Date data;

    @ElementCollection
    @OneToMany
    private List<ItemPedido> itensVenda;

    @Column(name = "total")
    private float total;

    @OneToOne
    @JoinColumn(name = "idformas_pagamento")
    private FormaPagamento forma;

    @Column(name = "vlr_frete")
    private double vlrFrete;

    @OneToOne
    @JoinColumn(name = "idtransportadora")
    private Transportadora transportadora;

    @Override
    public Integer getId() {
        return id;
    }

    public Venda() {
        this.itensVenda = new ArrayList<>();
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
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        this.total = 0.00f;
        for (ItemPedido ip : this.getItensVenda()) {
            this.total += ip.getProduto().getVlrVenda() * ip.getQuantidade();

        }
        double vlr = total * 1.25;

        this.setVlrFrete(vlr);
        total += getVlrFrete();

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

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the vlrFrete
     */
    public double getVlrFrete() {
        return vlrFrete;
    }

    /**
     * @param vlrFrete the vlrFrete to set
     */
    public void setVlrFrete(double vlrFrete) {
        this.vlrFrete = vlrFrete;
    }

    /**
     * @param itensVenda the itensVenda to set
     */
    public void setItensVenda(List<ItemPedido> itensVenda) {
        this.itensVenda = itensVenda;
    }

    /**
     * @return the transportadora
     */
    public Transportadora getTransportadora() {
        return transportadora;
    }

    /**
     * @param transportadora the transportadora to set
     */
    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }
}
