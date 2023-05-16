package pe.cibertec.ecommerce.ApiCustomer.Exception;


public class EntityNotFound extends RuntimeException{
    
    public EntityNotFound(String message){
        super(message);
    }
}
