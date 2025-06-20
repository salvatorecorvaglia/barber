package com.barber.be.mapper;

import com.barber.be.dto.ServiceDTO;
import com.barber.be.entity.Service;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServiceMapper {

    ServiceDTO toDTO(Service service);

    Service toEntity(ServiceDTO dto);
}
