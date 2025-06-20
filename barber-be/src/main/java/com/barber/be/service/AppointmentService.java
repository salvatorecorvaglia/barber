package com.barber.be.service;

import com.barber.be.entity.Appointment;
import com.barber.be.entity.Barber;
import com.barber.be.entity.Customer;
import com.barber.be.entity.OfferedService;
import com.barber.be.exception.ResourceNotFoundException;
import com.barber.be.repository.AppointmentRepository;
import com.barber.be.repository.BarberRepository;
import com.barber.be.repository.CustomerRepository;
import com.barber.be.repository.OfferedServiceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final CustomerRepository customerRepository;
    private final BarberRepository barberRepository;
    private final OfferedServiceRepository offeredServiceRepository;

    public List<Appointment> findByCustomerId(Long customerId) {
        return appointmentRepository.findByCustomerId(customerId);
    }

    @Transactional
    public Appointment saveWithRelations(Appointment appointment) {
        // Carica entità reali dai repository
        Customer customer = customerRepository.findById(appointment.getCustomer().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        Barber barber = barberRepository.findById(appointment.getBarber().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Barber not found"));
        OfferedService offeredService = offeredServiceRepository.findById(appointment.getOfferedService().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Service not found"));

        appointment.setCustomer(customer);
        appointment.setBarber(barber);
        appointment.setOfferedService(offeredService);

        return appointmentRepository.save(appointment);
    }
}
