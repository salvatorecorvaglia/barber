package com.barber.be.mapper;

import com.barber.be.dto.AdminDTO;
import com.barber.be.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDTO toDTO(Admin admin);

    Admin toEntity(AdminDTO dto);
}
