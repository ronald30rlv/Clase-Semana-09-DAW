package pe.cibertec.ecommerce.ApiCustomer.Exception;

import jakarta.persistence.EntityNotFoundException;
import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.cibertec.ecommerce.ApiCustomer.DTO.ErrorResponseDTO;

@RestControllerAdvice //Para interceptar todos los errores
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handlerEntityNotFound(EntityNotFoundException ex){
        var status =HttpStatus.NOT_FOUND;
        var errorResponse=new ErrorResponseDTO(status, ex.getMessage(),Arrays.toString(ex.getStackTrace()));
        return new ResponseEntity<>(errorResponse,status);        
    }
}
