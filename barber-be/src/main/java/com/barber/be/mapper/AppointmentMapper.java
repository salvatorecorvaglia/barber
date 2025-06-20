package com.barber.be.mapper;

import com.barber.be.dto.AppointmentDTO;
import com.barber.be.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "barber.id", target = "barberId")
    @Mapping(source = "service.id", target = "serviceId")
    AppointmentDTO toDTO(Appointment appointment);

    @Mapping(target = "customer", expression = "java(new Customer(dto.getCustomerId()))")
    @Mapping(target = "barber", expression = "java(new Barber(dto.getBarberId()))")
    @Mapping(target = "service", expression = "java(new Service(dto.getServiceId()))")
    Appointment toEntity(AppointmentDTO dto);
}
