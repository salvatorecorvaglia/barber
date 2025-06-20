package com.barber.be.repository;

import com.barber.be.entity.Appointment;
import com.barber.be.entity.Barber;
import com.barber.be.enumeration.AppointmentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByBarberAndAppointmentDateTimeBetween(Barber barber, LocalDateTime start, LocalDateTime end);

    List<Appointment> findByCustomerId(Long customerId);

    List<Appointment> findByStatus(AppointmentStatusEnum status);
}
