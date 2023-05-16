package pe.cibertec.ecommerce.ApiCustomer.service;

import java.util.List;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;

public interface CustomerService {
    public List<Customer> findAll();
    public Page<Customer> findAll(int nropage,int size);
    public Page<Customer> findByName(String name,int nropage,int size);
    
    public Customer findById(Long id);
    public Customer findByEmail(String email);
    public Customer findByPhone(String phone);
    public Customer add(Customer customer);
    public Customer update(Long id, Customer customer);
    public void delete(Long id);
    
}
