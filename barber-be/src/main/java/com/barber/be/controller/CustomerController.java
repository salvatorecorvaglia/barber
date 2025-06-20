package com.barber.be.controller;

import com.barber.be.dto.CustomerDTO;
import com.barber.be.entity.Customer;
import com.barber.be.mapper.CustomerMapper;
import com.barber.be.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    CustomerService customerService;
    CustomerMapper customerMapper;

    @GetMapping("/{email}")
    public ResponseEntity<CustomerDTO> getCustomerByEmail(@PathVariable String email) {
        return customerService.findByEmail(email)
                .map(customerMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customerEntity = customerMapper.toEntity(customerDTO);
        Customer saved = customerService.save(customerEntity);
        return ResponseEntity.ok(customerMapper.toDTO(saved));
    }
}
