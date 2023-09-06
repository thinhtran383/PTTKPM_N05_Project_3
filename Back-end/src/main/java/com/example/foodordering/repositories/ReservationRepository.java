package com.example.foodordering.repositories;

import com.example.foodordering.constant.ReservationStatus;
import com.example.foodordering.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r.id, r.customer.name, r.customer.phone, r.reservationTime, r.status FROM Reservation r")
    List<Object[]> getCustomerAndReservationTime();

    @Query("SELECT r.customer.name, r.customer.phone, r.reservationTime, r.status " +
            "FROM Reservation r " +
            "WHERE r.status = :status")
    List<Object[]> getCustomerNameAndPhoneByStatus(@Param("status") ReservationStatus status);
}