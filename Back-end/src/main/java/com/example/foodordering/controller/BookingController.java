package com.example.foodordering.controller;

import java.lang.StackWalker.Option;
import java.util.Optional;

import com.example.foodordering.models.ResponseObject;
import com.example.foodordering.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.foodordering.constant.ReservationStatus;
import com.example.foodordering.models.Customer;
import com.example.foodordering.models.Reservation;
import com.example.foodordering.repositories.CustomerRepository;
import com.example.foodordering.repositories.ReservationRepository;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "https://localhost:3000")
public class BookingController {
  @Autowired
  private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<ResponseObject> createReservation(@RequestBody Reservation reservation) {
        return bookingService.createReservation(reservation);
    }

    @GetMapping("")
    public ResponseEntity<ResponseObject> getCustomerAndReservationTime(){
      return ResponseEntity.status(HttpStatus.OK).body(
              new ResponseObject("ok", "Query successfully", bookingService.getCustomerAndReservationTime())
      );
    }

}
