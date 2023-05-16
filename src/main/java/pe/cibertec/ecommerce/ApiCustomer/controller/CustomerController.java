package pe.cibertec.ecommerce.ApiCustomer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;
import pe.cibertec.ecommerce.ApiCustomer.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;
    
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Customer>> findAll(){
        return new ResponseEntity<>(customerService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/findPageAll/nropage/{nropage}/size/{size}")
    public ResponseEntity<Page<Customer>> findAll(@PathVariable int nropage,@PathVariable int size){
        return new ResponseEntity<>(customerService.findAll(nropage,size),HttpStatus.OK);
    }
    @GetMapping("/findNamePageAll/name/{name}/nropage/{nropage}/size/{size}")
    public ResponseEntity<Page<Customer>> findAll(@PathVariable String name,@PathVariable int nropage,@PathVariable int size){
        return new ResponseEntity<>(customerService.findByName(name, nropage, size),HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.findById(id),HttpStatus.OK);
    }
    
    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<Customer> findByEmail(@PathVariable String email){
        return new ResponseEntity<>(customerService.findByEmail(email),HttpStatus.OK);
    }
    
    @GetMapping("/findByPhone")
    public ResponseEntity<Customer> findByPhone(@RequestParam String phone){
        return new ResponseEntity<>(customerService.findByPhone(phone),HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Customer> add(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.add(customer),HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id,
            @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.update(id, customer),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        customerService.delete(id);
    }
}
