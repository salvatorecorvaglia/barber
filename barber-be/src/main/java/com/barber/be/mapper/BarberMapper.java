package com.barber.be.mapper;

import com.barber.be.dto.BarberDTO;
import com.barber.be.entity.Barber;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BarberMapper {

    BarberDTO toDTO(Barber barber);

    Barber toEntity(BarberDTO dto);
}
