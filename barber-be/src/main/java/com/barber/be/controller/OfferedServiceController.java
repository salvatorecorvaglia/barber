package com.barber.be.controller;

import com.barber.be.dto.OfferedServiceDTO;
import com.barber.be.entity.OfferedService;
import com.barber.be.exception.ResourceNotFoundException;
import com.barber.be.mapper.OfferedServiceMapper;
import com.barber.be.service.OfferedServiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class OfferedServiceController {

    private final OfferedServiceService offeredServiceService;
    private final OfferedServiceMapper offeredServiceMapper;

    @GetMapping
    public ResponseEntity<List<OfferedServiceDTO>> getAll() {
        List<OfferedService> services = offeredServiceService.findAll();
        List<OfferedServiceDTO> dtos = services.stream()
                .map(offeredServiceMapper::toDTO)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferedServiceDTO> getById(@PathVariable Long id) {
        OfferedService service = offeredServiceService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id " + id));
        return ResponseEntity.ok(offeredServiceMapper.toDTO(service));
    }

    @PostMapping
    public ResponseEntity<OfferedServiceDTO> create(@RequestBody @Valid OfferedServiceDTO dto) {
        OfferedService entity = offeredServiceMapper.toEntity(dto);
        OfferedService saved = offeredServiceService.save(entity);
        return ResponseEntity.created(URI.create("/api/services/" + saved.getId()))
                .body(offeredServiceMapper.toDTO(saved));
    }
}
