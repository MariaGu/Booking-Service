package org.example.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateBookingRequest {
    public boolean autoSelect;
    public Long roomId;
    public String hotelName;
    private LocalDate startDate;
    private LocalDate endDate;
}
