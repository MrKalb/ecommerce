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
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
public class Cliente implements AbstractDto<Integer>, Serializable{

    @Id
    @GeneratedValue
    private Integer id; 
    
    @Column
    @NotNull
    private String nome; 
    
    @Column
    @NotNull
    private String endereco;
    
    @Column(name="endereco_de_entrega")
    @NotNull
    private String endereco_entrega; 
    
    @Column
    @NotNull
    private String CEP; 
    
    @Column
    @NotNull
    private String contato; 
    
    @Column
    @NotNull
    private String CPF; 
    
    @Column(name="idcidade")
    @NotNull
    private Cidade cidade; 
    
    @Override
    public Integer getId() {
        return id; 
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the CEP
     */
    public String getCEP() {
        return CEP;
    }

    /**
     * @param CEP the CEP to set
     */
    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    /**
     * @return the contato
     */
    public String getContato() {
        return contato;
    }

    /**
     * @param contato the contato to set
     */
    public void setContato(String contato) {
        this.contato = contato;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) throws Exception {
        if(ValidaCPF.isCPF(CPF)){
            this.CPF = CPF;
        }
        else {
            throw new Exception("CPF errado"); 
        }
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the endereco_entrega
     */
    public String getEndereco_entrega() {
        return endereco_entrega;
    }

    /**
     * @param endereco_entrega the endereco_entrega to set
     */
    public void setEndereco_entrega(String endereco_entrega) {
        this.endereco_entrega = endereco_entrega;
    }
    
    
}
