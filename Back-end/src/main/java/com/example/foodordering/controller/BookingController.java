package com.example.foodordering.controller;

import com.example.foodordering.entity.Table;
import com.example.foodordering.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.foodordering.DTO.ResponseObject;
import com.example.foodordering.constant.ReservationStatus;
import com.example.foodordering.entity.Reservation;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
  @Autowired
  private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> createReservation(@RequestBody Reservation reservation) {
        return bookingService.createReservation(reservation);
    }

    @GetMapping("")
    public ResponseEntity<ResponseObject> getCustomerAndReservationTime(@RequestParam(value = "filterByStatus", required = false) ReservationStatus filterByStatus){
      return ResponseEntity.status(HttpStatus.OK).body(
              new ResponseObject("ok", "Query successfully", bookingService.getCustomerAndReservationTime(filterByStatus))
      );
    }

    @PutMapping("/reservationId-{reservationId}")
    public ResponseEntity<ResponseObject> setTable(@PathVariable Long reservationId, @RequestBody Table table, @RequestParam(value = "delete", required = false) boolean delete){
      if(bookingService.setTable(reservationId, table, delete) == 1){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseObject("ok","Query successfully", "")
        );
      }

      if(bookingService.setTable(reservationId,table,delete) == 2){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseObject("ok", "Delete successfully", "")
        );
      }

      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
              new ResponseObject("false", "ReservationId not found","")
      );

    }

}
