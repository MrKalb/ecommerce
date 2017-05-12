/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.Dao;

import ecommerce.Dto.Usuario;
import ecommerce.Dto.Usuario_;
import ecommerce.auth.MultipleLoginsFound;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author igor
 */
@RequestScoped
public class UsuarioDao extends AbstractDao<Usuario>{
    
    public UsuarioDao(EntityManager em) {
        super(em, Usuario.class);
    }
    
    
    public Usuario getByEmail(String email) throws MultipleLoginsFound {
       
        CriteriaBuilder cb = this.getEntityManager().getCriteriaBuilder();                
        CriteriaQuery<Usuario> cqUsuario = cb.createQuery(Usuario.class);
        Root r = cqUsuario.from(Usuario.class);
        cqUsuario.select(r);
        
        Predicate emailEq = cb.equal(r.get(Usuario_.email),email);        
        cqUsuario.where(emailEq);
        
         
        ArrayList<Usuario> lista = (ArrayList<Usuario>) this.getByCriteria(cqUsuario);   
        
        if (!lista.isEmpty() && lista.size() > 1)
            throw new MultipleLoginsFound("Múltiplos usuários com o mesmo email encontrados");
               
        return lista.isEmpty()? null: lista.get(0);
        
    }
    
    
    
}