/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.slf4j.MDC;

/**
 *
 * @author igor
 */
@Entity
public class Estoque implements AbstractDto<Integer>,Serializable {

    @Id
    @GeneratedValue
    private Integer id; 
    
    @Column 
    private Produto produto; 
    
    @Column
    @ManyToOne
    private Map<Produto, Integer > quantidade; 

    public Estoque(){
        quantidade = new HashMap();
    }
    
    @Override
    public Integer getId() {
        return this.id; 
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public Map<Produto, Integer> getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Produto produto, Integer quantidade) throws Exception {
        int i;   
       /* try{
                 i = Integer.parseInt(quantidade);
            }
            catch(NumberFormatException erro){
                throw new Exception("Problema para converter numeros,contate o suporte tecnico");
            }*/
            if (quantidade <= 0){
                throw new Exception("Quantidade nao pode ser negativa");
            }
            
            else{
                  this.quantidade.put(produto, quantidade );
            }
    }
    
}
