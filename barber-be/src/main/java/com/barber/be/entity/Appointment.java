package com.barber.be.entity;

import com.barber.be.enumeration.AppointmentStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id")
    private OfferedService offeredService;

    @FutureOrPresent
    private LocalDateTime appointmentDateTime;

    private String notes;

    @Enumerated(EnumType.STRING)
    private AppointmentStatusEnum status;


    public Appointment(Long id) {
        this.id = id;
    }
}
