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

/**
 *
 * @author igor
 */
@Entity
public class Entrega implements AbstractDto<Integer>,Serializable {

    @Id 
    @GeneratedValue
    private Integer id; 
    
    @Column(name="id_numero_pedido")
    private Venda numeroPedido; 
    
    @Column
    private Venda idvenda; 
    
    @Column
    private String status; 
    
    @Column(name = "idtransporadora")
    private Transportadora transporte; 
    
    
    @Override
    public Integer getId() {
        return id; 
    }

    /**
     * @return the numeroPedido
     */
    public Venda getNumeroPedido() {
        return numeroPedido;
    }

    /**
     * @param numeroPedido the numeroPedido to set
     */
    public void setNumeroPedido(Venda numeroPedido) {
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
    public Venda getIdvenda() {
        return idvenda;
    }

    /**
     * @param idvenda the idvenda to set
     */
    public void setIdvenda(Venda idvenda) {
        this.idvenda = idvenda;
    }
    
    
}
