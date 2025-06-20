package com.barber.be.service;

import com.barber.be.entity.Barber;
import com.barber.be.repository.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarberService {

    BarberRepository barberRepository;

    public Optional<Barber> findById(Long id) {
        return barberRepository.findById(id);
    }

    public Barber save(Barber barber) {
        return barberRepository.save(barber);
    }
}
