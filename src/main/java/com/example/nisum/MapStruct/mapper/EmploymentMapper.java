package com.example.nisum.MapStruct.mapper;

import com.example.nisum.MapStruct.dto.EmploymentDTO;
import com.example.nisum.MapStruct.model.Employment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmploymentMapper {

    EmploymentMapper INSTANCE = Mappers.getMapper(EmploymentMapper.class);

    EmploymentDTO convert(Employment employment);
}
