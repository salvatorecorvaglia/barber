package com.barber.be.repository;

import com.barber.be.entity.OfferedService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferedServiceRepository extends JpaRepository<OfferedService, Long> {
}
