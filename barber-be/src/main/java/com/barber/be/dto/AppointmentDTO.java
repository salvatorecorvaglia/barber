package com.barber.be.dto;

import com.barber.be.entity.Appointment.AppointmentStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDTO {

    private Long id;

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Barber ID is required")
    private Long barberId;

    @NotNull(message = "Service ID is required")
    private Long serviceId;

    @FutureOrPresent(message = "Appointment date/time must be now or in the future")
    private LocalDateTime appointmentDateTime;

    private String notes;

    private AppointmentStatus status;
}
