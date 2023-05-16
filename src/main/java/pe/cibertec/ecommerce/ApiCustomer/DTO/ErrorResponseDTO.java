package pe.cibertec.ecommerce.ApiCustomer.DTO;

import java.util.Date;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponseDTO {
    private Date timestamp; //para guardar la fecha y hora a la que se origina el error (2013-05-15 20:05:10)
    private int code; //el codigo del error (404)
    private String status; //la descripcion del error (Not Founf)
    private Object message; //Customer with id 4 not found
    private String stackTrace; //Detalles del error
    
    public ErrorResponseDTO(HttpStatus httpstatus,Object message,String stackTrace){
        this.timestamp=new Date();
        this.code=httpstatus.value();
        this.status=httpstatus.name();
        this.message=message;
        this.stackTrace=stackTrace;
    }
}
