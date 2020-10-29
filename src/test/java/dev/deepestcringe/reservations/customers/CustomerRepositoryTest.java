package dev.deepestcringe.reservations.customers;

import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    @Mock
    EntityManager entityManagerMock;

    @Mock
    Query mockQuery;

    CustomerRepository repo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        repo = new CustomerRepository(entityManagerMock);
        makeMocks();
    }

    @Test
    void getAllCustomers_returnsNotNull() {
        //act
        var actual = repo.getAllCustomers();

        //assert
        assertNotNull(actual);
    }

    @Test
    void getAllCustomers_CallsNativeQuery() {
        //act
        repo.getAllCustomers();

        //assert
        Mockito.verify(entityManagerMock,Mockito.atLeastOnce()).createNativeQuery(Mockito.anyString());
    }

    @Test
    void getAllCustomers_hasAtLeastOneResult() {
        //act
        var actual = repo.getAllCustomers();

        //assert
        assert(!actual.isEmpty());
    }

    @Test
    void getAllCustomers_callsGetResultList() {
        //act
        repo.getAllCustomers();

        //assert
        Mockito.verify(mockQuery,Mockito.atLeastOnce()).getResultList();
    }

    private void makeMocks(){
        Mockito.when(entityManagerMock.createNativeQuery(Mockito.anyString())).thenReturn(mockQuery);
        List<Object[]> mockedRes = new ArrayList<>();
        Object[] row1 = {1,"Jerry"};
        mockedRes.add(row1);

        Mockito.when(mockQuery.getResultList()).thenReturn(mockedRes);
    }
}