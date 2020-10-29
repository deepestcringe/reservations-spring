package dev.deepestcringe.reservations.customers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerGetService {

    CustomerRepository customerRepository;

    public CustomerGetService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponsePOJO> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }


}
