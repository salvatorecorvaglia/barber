package com.barber.be.controller;

import com.barber.be.dto.CustomerDTO;
import com.barber.be.exception.ResourceNotFoundException;
import com.barber.be.mapper.CustomerMapper;
import com.barber.be.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping("/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
        var customer = customerService.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with email %s not found".formatted(email)));

        return ResponseEntity.ok(customerMapper.toDTO(customer));
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        var entity = customerMapper.toEntity(customerDTO);
        var saved = customerService.save(entity);
        return ResponseEntity.created(URI.create("/api/customers/" + saved.getEmail()))
                .body(customerMapper.toDTO(saved));
    }
}
