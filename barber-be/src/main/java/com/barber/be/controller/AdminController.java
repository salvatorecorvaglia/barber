package com.barber.be.controller;

import com.barber.be.dto.AdminDTO;
import com.barber.be.entity.Admin;
import com.barber.be.exception.ResourceNotFoundException;
import com.barber.be.mapper.AdminMapper;
import com.barber.be.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final AdminMapper adminMapper;

    @GetMapping
    public ResponseEntity<List<AdminDTO>> getAll() {
        return ResponseEntity.ok(adminService.findAll()
                .stream()
                .map(adminMapper::toDTO)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getById(@PathVariable Long id) {
        Admin admin = adminService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + id));
        return ResponseEntity.ok(adminMapper.toDTO(admin));
    }

    @PostMapping
    public ResponseEntity<AdminDTO> create(@RequestBody @Valid AdminDTO dto) {
        Admin saved = adminService.save(adminMapper.toEntity(dto));
        return ResponseEntity.created(URI.create("/api/admins/" + saved.getId()))
                .body(adminMapper.toDTO(saved));
    }
}
