package com.barber.be.controller;

import com.barber.be.dto.BarberDTO;
import com.barber.be.entity.Barber;
import com.barber.be.exception.ResourceNotFoundException;
import com.barber.be.mapper.BarberMapper;
import com.barber.be.service.BarberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/barbers")
@RequiredArgsConstructor
public class BarberController {

    private final BarberService barberService;
    private final BarberMapper barberMapper;

    @GetMapping
    public ResponseEntity<List<BarberDTO>> getAll() {
        List<BarberDTO> list = barberService.findAll()
                .stream()
                .map(barberMapper::toDTO)
                .toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarberDTO> getById(@PathVariable Long id) {
        Barber barber = barberService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Barber not found with id " + id));
        return ResponseEntity.ok(barberMapper.toDTO(barber));
    }

    @PostMapping
    public ResponseEntity<BarberDTO> create(@RequestBody @Valid BarberDTO dto) {
        Barber saved = barberService.save(barberMapper.toEntity(dto));
        return ResponseEntity.created(URI.create("/api/barbers/" + saved.getId()))
                .body(barberMapper.toDTO(saved));
    }
}
