package com.example.foodordering.repositories;

import com.example.foodordering.constant.ReservationStatus;
import com.example.foodordering.entity.Reservation;
import com.example.foodordering.models.BookingDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<Reservation> findById(Long id);
    @Query("SELECT NEW com.example.foodordering.models.BookingDTO (r.id, r.customer.name, r.customer.phone,r.tableId.id ,r.reservationTime, r.status) FROM Reservation r")
    List<BookingDTO> getCustomerAndReservationTime();

    @Query("SELECT NEW com.example.foodordering.models.BookingDTO(r.id, r.customer.name, r.customer.phone, r.tableId.id ,r.reservationTime, r.status) " +
            "FROM Reservation r " +
            "WHERE r.status = :status")
    List<BookingDTO> getCustomerNameAndPhoneByStatus(@Param("status") ReservationStatus status);



}