package pe.cibertec.ecommerce.ApiCustomer.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiCustomer.Exception.EntityNotFound;
import pe.cibertec.ecommerce.ApiCustomer.dao.CustomerRepository;
import pe.cibertec.ecommerce.ApiCustomer.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(()->
                new EntityNotFound("Cliente con cod: "+id.toString()+" no existe, verificar"));  
    }
    
    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);//.orElse(null);  
    }

    @Override
    public Customer findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public Customer add(Customer customer) {
        return customerRepository.save(customer);
        
    }

    @Override
    public Customer update(Long id, Customer customer) {
        Customer customerDB = customerRepository.findById(id).get();
        customerDB.setName(customer.getName());
        customerDB.setEmail(customer.getEmail());
        customerDB.setPhone(customer.getPhone());
        return customerRepository.save(customerDB);
    }

    @Override
    public void delete(Long id) {
        Customer customerDB = customerRepository.findById(id).get();
        customerRepository.delete(customerDB);
    }

    @Override
    public Page<Customer> findAll(int nropage, int size) {
        return customerRepository.findAll(PageRequest.of(size, size));
    }

    @Override
    public Page<Customer> findByName(String name, int nropage, int size) {
        return customerRepository.findByNameContaining(name, PageRequest.of(nropage, size));
    }
    
}
