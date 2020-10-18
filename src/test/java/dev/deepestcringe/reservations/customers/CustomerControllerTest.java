package dev.deepestcringe.reservations.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerControllerTest {

    CustomerController controller;

    @Mock
    CustomerGetService serviceMock;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new CustomerController(serviceMock);
        Mockito.when(serviceMock.getAllCustomers()).thenReturn(makeMocks());
    }

    @Test
    void searchForCustomerByName_doesNotReturnNull() {

        //act
        var actual = controller.searchForCustomerByName("");

        //assert
        assertNotNull(actual);
    }

    @Test
    void searchForCustomerByName_doesNotAMapWithCustomerKeyMissingValue() {

        //act
        var actual = controller.searchForCustomerByName("");

        //assert
        assertNotNull(actual.get("customers"));
    }

    @Test
    void searchForCustomerByName_callsService() {

        //act
        var actual = controller.searchForCustomerByName("");

        //assert
        Mockito.verify(serviceMock,Mockito.atLeast(1)).getAllCustomers();
    }



    List<CustomerResponsePOJO> makeMocks(){
        List<CustomerResponsePOJO> ret = new ArrayList<>();

        CustomerResponsePOJO mary = CustomerResponsePOJO.builder()
                .name("mary").reservations(new ArrayList<>()).build();

        ret.add(mary);

        return ret;
    }


}