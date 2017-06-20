/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecommerce.interceptadores;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import ecommerce.Controller.ClienteController;
import ecommerce.Dto.Usuario;
import ecommerce.annotations.Client;
import ecommerce.auth.Authenticator;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author igor
 */

@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Client.class)
public class ClientInterceptor  {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
   // private final ControllerMethod controllerMethod;
    
    /*   	@Inject
    public AuthInterceptor(ControllerMethod controllerMethod){
    this.controllerMethod=controllerMethod;
    }
    
    @Deprecated
    AuthInterceptor(){
    this(null);
    }*/
    
    @Inject
    Result result;
    
    
    @Inject
    private Authenticator auth;
    
    @Inject
    private Usuario us;
    
    
    @Inject
    private HttpServletRequest request;
    
    
    
    @AroundCall
    public void doBeforeCheck(SimpleInterceptorStack stack){
        if(!this.auth.isLogged()){
            this.auth.setNextPath(this.request.getRequestURI().substring(this.request.getContextPath().length()));
            this.result.redirectTo(ClienteController.class).login();
        }
        else{
            stack.next( );
        }
    }
    
}
