package com.example.foodordering.models;

import com.example.foodordering.constant.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString

public class BookingDTO {
    private Long id;
    private String name;
    private String phone;
    private LocalDateTime reservationTime;
    private ReservationStatus status;
}
