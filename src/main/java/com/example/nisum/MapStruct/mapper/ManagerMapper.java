package com.example.nisum.MapStruct.mapper;

import com.example.nisum.MapStruct.dto.ManagerDTO;
import com.example.nisum.MapStruct.model.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ManagerMapper {

    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    ManagerDTO convert(Manager manager);
}
