package dev.deepestcringe.reservations.customers;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    EntityManager em;

    public CustomerRepository(EntityManager em) {
        this.em = em;
    }

    public List<CustomerResponsePOJO> getAllCustomers(){

        List<CustomerResponsePOJO> ret = new ArrayList<>();

        List<Object[]> rows = em.createNativeQuery("SELECT * FROM reservations.customers" ).getResultList();

        System.out.println("\n\n\n" +rows + "\n\n\n\n");

        for( Object[] row:rows ){
            System.out.println("Should be Name:" + row[1]);
            var myNewCustomer =
                    CustomerResponsePOJO.builder()
                            .name((String)row[1])
                            .reservations(new ArrayList<>())
                            .build();
            ret.add(myNewCustomer);
        }

        return ret;

    }






}


