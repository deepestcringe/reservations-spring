package dev.deepestcringe.reservations.customers;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerGetService {

    public CustomerGetService() {
    }

    public List<CustomerResponsePOJO> getAllCustomers(){
        List<CustomerResponsePOJO>  ret = new ArrayList<>();

        CustomerResponsePOJO jerry = CustomerResponsePOJO.builder()
                .name("Jerry").reservations(new ArrayList<>()).build();

        ret.add(jerry);

        return ret;
    }


}
