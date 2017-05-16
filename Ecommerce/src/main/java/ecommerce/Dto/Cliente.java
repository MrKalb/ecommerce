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
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
public class Cliente implements AbstractDto<Integer>, Serializable{

    @Id
    @SequenceGenerator(name = "cliente_id_seq", sequenceName = "cliente_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cliente_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id; 
    
    @Column(name = "nome")
    @NotNull
    private String nome; 
    
    @Column(name = "endereco")
    @NotNull
    private String endereco;
    
    @Column(name="endereco_de_entrega")
    @NotNull
    private String enderecoEntrega; 
    
    @Column(name = "cep")
    @NotNull
    private String cep; 
    
    @Column(name = "contato")
    @NotNull
    private String contato; 
    
    @Column(name = "cpf")
    @NotNull
    private String cpf; 
    
    @JoinColumn(name="idcidade")
    @OneToOne
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
    public String getCep() {
        return cep;
    }

    /**
     * @param CEP the CEP to set
     */
    public void setCep(String CEP) {
        this.cep = CEP;
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
    public String getCpf() {
        return cpf;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCpf(String CPF) throws Exception {
        if(ValidaCPF.isCPF(CPF)){
            this.cpf = CPF;
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
    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    /**
     * @param endereco_entrega the endereco_entrega to set
     */
    public void setEnderecoEntrega(String endereco_entrega) {
        this.enderecoEntrega = endereco_entrega;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
