package com.example.nisum.MapStruct.mapper;

import com.example.nisum.MapStruct.dto.PersonDTO;
import com.example.nisum.MapStruct.model.Person;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        uses = ManagerMapper.class)
public interface PersonMapperAdderPreferred {
    PersonDTO map(Person person);
}