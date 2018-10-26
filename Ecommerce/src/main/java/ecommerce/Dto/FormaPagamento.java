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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "formas_pagamento")
@DynamicUpdate
public class FormaPagamento implements AbstractDto<Integer>,Serializable {

    @Id
    @SequenceGenerator(name = "formas_pagamento_id_seq", sequenceName = "formas_pagamento_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "formas_pagamento_id_seq")
    @Column(name = "id",columnDefinition = "serial")
    private Integer id; 
    
    @Column
    @NotNull
    private String descricao; 
    
	private String parcelas; 
	
    @Override
    public Integer getId() {
        return id; 
    }

	
	public void setParcelas(String parcelas){
		this.parcelas = parcelas;	
	}
	
	public String getParcelas(){
		return this.parcelas; 
	}
	
    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    
}
