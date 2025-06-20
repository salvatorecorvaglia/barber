package com.barber.be.controller;

import com.barber.be.dto.AppointmentDTO;
import com.barber.be.mapper.AppointmentMapper;
import com.barber.be.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<AppointmentDTO>> getByCustomer(@PathVariable Long customerId) {
        var list = appointmentService.findByCustomerId(customerId)
                .stream()
                .map(appointmentMapper::toDTO)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody @Valid AppointmentDTO dto) {
        var entity = appointmentMapper.toEntity(dto);
        var saved = appointmentService.saveWithRelations(entity);
        return ResponseEntity.ok(appointmentMapper.toDTO(saved));
    }
}
