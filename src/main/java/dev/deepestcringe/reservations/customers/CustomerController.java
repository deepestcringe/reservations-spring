package dev.deepestcringe.reservations.customers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    private CustomerGetService service;

    public CustomerController(CustomerGetService serviceIn) {
        service = serviceIn;
    }

    @CrossOrigin(origins = "http://localhost:63344")
    @GetMapping(value = "/customers")
    public Map<String, List<CustomerResponsePOJO>> searchForCustomerByName(@RequestParam(required = false) String name) {
        var responseList = service.getAllCustomers();
        return Collections.singletonMap("customers", responseList);
    }
}
