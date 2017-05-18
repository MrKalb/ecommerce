package ecommerce.auth;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import ecommerce.Dto.Usuario;
import ecommerce.annotations.Administrative;
import java.io.Serializable;
import java.util.Calendar;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author diego
 */
@SessionScoped
public class Authenticator implements Serializable{
    private Usuario usuario;
    private Calendar loginTime;
    private String nextPath= "";
    
    @Inject
    private Result result;
    
    /*    	@Inject ControllerMethod controllerMethod;
    
    @Accepts
    public boolean accepts() {
    return !controllerMethod.containsAnnotation(Administrative.class);
    }*/
    
    
    public String getNextPath() {
        return nextPath;
    }

    public void setNextPath(String nextPath) {
        this.nextPath = nextPath;
    }
    
    
    
    
        
    
    public void doLogin(Usuario usuario){       
        this.usuario = usuario;
        this.loginTime = Calendar.getInstance();
        if (!this.nextPath.isEmpty())
            result.redirectTo(this.nextPath);
    }
    
    public void doLogout(){
        this.usuario = null;
        this.nextPath="";
    }
    
    
    
    public boolean  isLogged(){
        
        //Tempo maior que 10 minutos gera logout do usuário
        if(this.loginTime != null &&  (Calendar.getInstance().getTimeInMillis() - this.loginTime.getTimeInMillis()) > 1000*60*60*10)
             this.doLogout();
        else
            this.loginTime = Calendar.getInstance();
            
        return this.usuario != null;
    
    }
    
    
}
