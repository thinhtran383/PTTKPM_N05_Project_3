package com.example.foodordering.repositories;

import com.example.foodordering.constant.ReservationStatus;
import com.example.foodordering.entity.Reservation;
import com.example.foodordering.models.BookingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT NEW com.example.foodordering.models.BookingDTO (r.id, r.customer.name, r.customer.phone, r.reservationTime, r.status) FROM Reservation r")
    List<BookingDTO> getCustomerAndReservationTime();

    @Query("SELECT NEW com.example.foodordering.models.BookingDTO(r.id, r.customer.name, r.customer.phone, r.reservationTime, r.status) " +
            "FROM Reservation r " +
            "WHERE r.status = :status")
    List<BookingDTO> getCustomerNameAndPhoneByStatus(@Param("status") ReservationStatus status);

}