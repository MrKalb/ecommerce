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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "transportadora")
public class Transportadora implements AbstractDto<Integer>,Serializable {

    @Id
    @SequenceGenerator(name = "transportadora_id_seq", sequenceName = "transportadora_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transportadora_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id; 
    
    @Column(name = "razao_social")
    private String razao;
    
    @Column(name = "nome_fantasia")
    private String fantasia; 
    
    @Column
    private String endereco;
    
    @JoinColumn(name="idcidade")
    @OneToOne
    private Cidade cidade;
    
    @Column(name = "cnpj")
    private String cnpj; 
    
    
    
    @Override
    public Integer getId() {
        return id; 
    }

    /**
     * @return the razao
     */
    public String getRazao() {
        return razao;
    }

    /**
     * @param razao the razao to set
     */
    public void setRazao(String razao) {
        this.razao = razao;
    }

    /**
     * @return the fantasia
     */
    public String getFantasia() {
        return fantasia;
    }

    /**
     * @param fantasia the fantasia to set
     */
    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
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
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) throws Exception {
       if(ValidaCNPJ.isCNPJ(cnpj)){
        this.cnpj = cnpj;   
       }
       else { 
          throw new Exception("CNPJ errado");
       }
        
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
}
