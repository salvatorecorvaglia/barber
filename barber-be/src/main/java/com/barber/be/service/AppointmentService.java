package com.barber.be.service;

import com.barber.be.entity.Appointment;
import com.barber.be.entity.Barber;
import com.barber.be.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    AppointmentRepository appointmentRepository;

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> findByBarberAndDateRange(Barber barber, LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByBarberAndAppointmentDateTimeBetween(barber, start, end);
    }

    public List<Appointment> findByCustomerId(Long customerId) {
        return appointmentRepository.findByCustomerId(customerId);
    }
}
