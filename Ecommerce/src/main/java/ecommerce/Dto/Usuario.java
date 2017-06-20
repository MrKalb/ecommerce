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
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements AbstractDto<Integer>, Serializable{

    
    @Id
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usuario_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id;
    
    @Column(name = "login")
    @NotNull
    private String email;
    
    @Column(name = "senha")
    @NotNull
    private String password;
    
    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente; 
    
    @Column(name = "tipo")
    private String tipo; 
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public Integer getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}