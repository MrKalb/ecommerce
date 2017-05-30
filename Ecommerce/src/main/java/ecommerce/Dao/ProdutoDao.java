/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.ItemPedido;
import ecommerce.Dto.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author igor
 */
public class ProdutoDao extends AbstractDao<Produto> {
    
    private EntityManager em;
    
    public ProdutoDao(EntityManager em) {
        super(em, Produto.class);
    }
    
            public List<Produto> getCategoria(String tipo){
          TypedQuery<Produto> p1 = em.createQuery("SELECT * FROM tipocategoria tc join produto p on tc.idproduto = p.id join categoria c on tc.idcategoria= c.id where"
                  + " c.descricao like" + "%"+tipo+"%" , Produto.class);
          return p1.getResultList();
    }
    
}
