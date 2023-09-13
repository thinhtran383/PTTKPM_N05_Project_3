package com.example.foodordering.services;

import com.example.foodordering.constant.ReservationStatus;
import com.example.foodordering.constant.TableStatus;
import com.example.foodordering.entity.Customer;
import com.example.foodordering.entity.Reservation;
import com.example.foodordering.entity.Table;
import com.example.foodordering.models.BookingDTO;
import com.example.foodordering.models.ResponseObject;
import com.example.foodordering.repositories.CustomerRepository;
import com.example.foodordering.repositories.ReservationRepository;
import com.example.foodordering.repositories.TableRepository;
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

    @Autowired
    private TableRepository tableRepository;

    private Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
            Optional<Customer> existingCustomer = customerRepository.findByPhone(customer.getPhone());
            return existingCustomer.orElseGet(() -> customerRepository.save(customer));
        }
        return null;
    }

    public ResponseEntity<ResponseObject> createReservation(Reservation reservation) { // can sua lai
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



    public List<BookingDTO> getCustomerAndReservationTime(@RequestParam(value = "filterByStatus", required = false) ReservationStatus filterByStatus){ // filter By Status
        if (filterByStatus == null) {
            return reservationRepository.getCustomerAndReservationTime();
        } else {
            return reservationRepository.getCustomerNameAndPhoneByStatus(filterByStatus);
        }
    }

    public int setTable(Long reservationId, Table table, boolean isDelete){
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if(isDelete){
            assert reservation != null;
            reservation.setStatus(Rejected);
            reservationRepository.save(reservation);
            return 2;
        }


        if (reservation != null) {
            table.setStatus(TableStatus.Booked); // cap nhat trang thai ban
            reservation.setStatus(ReservationStatus.Accepted);
            reservation.setTableId(table); // cap nhat so ban
            reservationRepository.save(reservation);
            tableRepository.save(table);
            return 1;
        }

        return 0;
    }


}
