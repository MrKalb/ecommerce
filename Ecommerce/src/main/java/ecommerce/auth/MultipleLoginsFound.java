package ecommerce.auth;

/**
 *
 * @author diego
 */
public class MultipleLoginsFound extends RuntimeException{

    public MultipleLoginsFound(String message) {
        super(message);
    }

    
}
