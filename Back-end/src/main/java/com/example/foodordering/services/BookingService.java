package com.example.foodordering.services;

import com.example.foodordering.constant.ReservationStatus;
import com.example.foodordering.models.Customer;
import com.example.foodordering.models.Reservation;
import com.example.foodordering.models.ResponseObject;
import com.example.foodordering.repositories.CustomerRepository;
import com.example.foodordering.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.foodordering.constant.ReservationStatus.*;

@Service
public class BookingService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReservationRepository reservationRepository;
    
    private Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            Optional<Customer> existingCustomer = customerRepository.findByPhone(customer.getPhone());
            return existingCustomer.orElseGet(() -> customerRepository.save(customer));
        }
        return null;
    }

    public ResponseEntity<ResponseObject> createReservation(Reservation reservation) {
        try {
            Customer customer = saveOrUpdateCustomer(reservation.getCustomer());

            reservation.setCustomer(customer);
            reservation.setStatus(Pending);
            reservationRepository.save(reservation);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Reservation created successfully", "")
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("false", "Reservation cannot create", "")
            );
        }
    }



    public List<Object[]> getCustomerAndReservationTime(@RequestParam(value = "filterByStatus", required = false) ReservationStatus filterByStatus){ // filter By Status
        if (filterByStatus == null) {
            return reservationRepository.getCustomerAndReservationTime();
        } else {
            return reservationRepository.getCustomerNameAndPhoneByStatus(filterByStatus);
        }
    }
}
