package dev.deepestcringe.reservations.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerGetServiceTest {

    CustomerGetService customerGetService;

    @Mock
    CustomerRepository mockCustRepo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerGetService = new CustomerGetService(mockCustRepo);
        makeMocks();
    }

    @Test
    void getAll_ReturnsNotNull() {
        //act
        var actual = customerGetService.getAllCustomers();

        //assert
        assertNotNull(actual);
    }

    @Test
    void getAll_ReturnsAtLeastOneCustomer() {
        //act
        var actual = customerGetService.getAllCustomers();

        //assert
        assertTrue(actual.size() > 0);

    }

    private void makeMocks(){
        List<CustomerResponsePOJO> mocksresp = new ArrayList<>();
        mocksresp.add(CustomerResponsePOJO.builder()
                .name("jerry")
                .reservations(new ArrayList<>()).build());

        Mockito.when(mockCustRepo.getAllCustomers())
                .thenReturn(mocksresp);
    }


}