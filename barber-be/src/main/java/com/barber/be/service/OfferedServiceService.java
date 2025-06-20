package com.barber.be.service;

import com.barber.be.entity.OfferedService;
import com.barber.be.repository.OfferedServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferedServiceService {  // nome diverso, più chiaro

    private final OfferedServiceRepository offeredServiceRepository;

    public List<OfferedService> findAll() {
        return offeredServiceRepository.findAll();
    }

    public Optional<OfferedService> findById(Long id) {
        return offeredServiceRepository.findById(id);
    }

    public OfferedService save(OfferedService service) {
        return offeredServiceRepository.save(service);
    }
}
