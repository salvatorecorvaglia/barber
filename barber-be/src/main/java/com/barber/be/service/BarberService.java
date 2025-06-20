package com.barber.be.service;

import com.barber.be.entity.Barber;
import com.barber.be.repository.BarberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarberService {

    private final BarberRepository barberRepository;

    public List<Barber> findAll() {
        return barberRepository.findAll();
    }

    public Optional<Barber> findById(Long id) {
        return barberRepository.findById(id);
    }

    @Transactional
    public Barber save(Barber barber) {
        return barberRepository.save(barber);
    }
}
