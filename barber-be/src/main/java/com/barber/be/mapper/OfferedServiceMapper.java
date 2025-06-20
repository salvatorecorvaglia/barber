package com.barber.be.mapper;

import com.barber.be.dto.OfferedServiceDTO;
import com.barber.be.entity.OfferedService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferedServiceMapper {

    OfferedServiceDTO toDTO(OfferedService offeredService);

    OfferedService toEntity(OfferedServiceDTO dto);
}
