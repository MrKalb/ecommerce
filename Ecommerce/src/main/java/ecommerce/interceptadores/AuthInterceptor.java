package ecommerce.interceptadores;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import ecommerce.Controller.ClienteController;
import ecommerce.annotations.Administrative;
import ecommerce.auth.Authenticator;
import org.slf4j.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;



/**
 *
 * @author diego
 */
@Intercepts
@RequestScoped
@AcceptsWithAnnotations(Administrative.class)
public class AuthInterceptor {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Inject
    Result result;
    
    
    @Inject
    private Authenticator auth;
    
    
    @Inject
    private HttpServletRequest request;
    
    
    @AroundCall
    public void doBeforeCheck(SimpleInterceptorStack stack){
        if(!this.auth.isLogged()){
            this.auth.setNextPath(this.request.getRequestURI().substring(this.request.getContextPath().length()));
            this.result.redirectTo(ClienteController.class).login();
        }
        else
            stack.next( );
    }
    
}
