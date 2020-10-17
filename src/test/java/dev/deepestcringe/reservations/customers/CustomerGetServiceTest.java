package dev.deepestcringe.reservations.customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerGetServiceTest {

    CustomerGetService customerGetService;

    @BeforeEach
    void setUp() {
        customerGetService = new CustomerGetService();
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


}