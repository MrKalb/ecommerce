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
public class Transportadora implements AbstractDto<Integer>,Serializable {

    @Id
    @GeneratedValue
    private Integer id; 
    
    @Column(name = "razao_social")
    private String razao;
    
    @Column(name = "nome_fantasia")
    private String fantasia; 
    
    @Column
    private String endereco;
    
    @Column(name="idcidade")
    private Cidade cidade;
    
    @Column
    @NotNull
    private String CNPJ; 
    
    
    
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
     * @return the CNPJ
     */
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     * @param CNPJ the CNPJ to set
     */
    public void setCNPJ(String CNPJ) throws Exception {
       if(ValidaCNPJ.isCNPJ(CNPJ)){
        this.CNPJ = CNPJ;   
       }
       else { 
          throw new Exception("CNPJ errado");
       }
        
    }
    
}
