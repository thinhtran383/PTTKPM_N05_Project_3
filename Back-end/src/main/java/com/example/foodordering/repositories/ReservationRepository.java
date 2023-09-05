package com.example.foodordering.repositories;

import com.example.foodordering.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r.customer.name, r.reservationTime, r.status FROM Reservation r")
    List<Object[]> getCustomerAndReservationTime();

}
