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

/**
 *
 * @author igor
 */
@Entity
public class Entrega implements AbstractDto<Integer>,Serializable {

    @Id
    @SequenceGenerator(name = "entrega_id_seq", sequenceName = "entrega_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "entrega_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id; 
    
    @Column(name="id_numero_pedido")
    private Integer numeroPedido; 
    
    @Column(name = "idvenda")
    private Integer idvenda; 
    
    @Column(name = "status")
    private String status; 
    
    @JoinColumn(name = "idtransportadora")
    @OneToOne
    private Transportadora transporte; 
    
    @OneToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente; 
    
    
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the transporte
     */
    public Transportadora getTransporte() {
        return transporte;
    }

    /**
     * @param transporte the transporte to set
     */
    public void setTransporte(Transportadora transporte) {
        this.transporte = transporte;
    }

    /**
     * @return the idvenda
     */
    public Integer getIdvenda() {
        return idvenda;
    }

    /**
     * @param idvenda the idvenda to set
     */
    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
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
    
    
}
