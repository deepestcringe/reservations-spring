package dev.deepestcringe.reservations.customers;

import dev.deepestcringe.reservations.reservations.Reservation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerResponsePOJO {
    private String name;
    private List<Reservation> reservations;
}
