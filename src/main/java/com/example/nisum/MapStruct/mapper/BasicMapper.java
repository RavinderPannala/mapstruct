package com.example.nisum.MapStruct.mapper;

import com.example.nisum.MapStruct.exception.Validator;
import com.example.nisum.MapStruct.exception.ValidatorException;
import com.example.nisum.MapStruct.model.Address;
import com.example.nisum.MapStruct.dto.BasicUserDto;
import com.example.nisum.MapStruct.model.Education;
import com.example.nisum.MapStruct.dto.PersonDTO;
import com.example.nisum.MapStruct.model.BasicUser;
import com.example.nisum.MapStruct.model.Employment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ManagerMapper.class, EmploymentMapper.class, Validator.class})
public interface BasicMapper {

    BasicMapper INSTANCE = Mappers.getMapper(BasicMapper.class);

    //Same fields Mappings

    //Exception Handling during Mapping
    BasicUserDto convert(BasicUser user) throws ValidatorException;

    //Inverse Mappings
    @InheritInverseConfiguration
    BasicUser convert(BasicUserDto basicUserDto) throws ValidatorException;

    //Custom Mapping Methods
    default PersonDTO convertCustom(BasicUser basicUser) {
        return PersonDTO.builder().id(String.valueOf(basicUser.getId()))
                .firstName(basicUser.getName().substring(0, basicUser.getName().indexOf(" ")))
                .lastName(basicUser.getName().substring(basicUser.getName().indexOf(" ") + 1))
                .build();
    }

    //Mapping from Several Source Objects
    @Mappings({
            @Mapping(source = "basicUser.id", target = "id"),
            @Mapping(source = "basicUser.name", target = "firstName"),
            @Mapping(source = "education.degreeName", target = "educationalQualification"),
            @Mapping(source = "address.city", target = "residentialCity"),
            @Mapping(source = "address.country", target = "residentialCountry")
    })
    PersonDTO convert(BasicUser basicUser, Education education, Address address);

    //Mapping Nested Objects
   /* @Mappings({
            @Mapping(source = "basicUser.id", target = "id"),
            @Mapping(source = "basicUser.name", target = "firstName"),
            @Mapping(source = "education.degreeName", target = "educationalQualification"),
            @Mapping(source = "address.city", target = "residentialCity"),
            @Mapping(source = "address.country", target = "residentialCountry")
    })
    PersonDTO convert(BasicUser basicUser, Education education, Address address, Employment employment);*/

    @Mappings({
            @Mapping(source = "basicUser.id", target = "id"),
            @Mapping(source = "basicUser.name", target = "firstName"),
            @Mapping(source = "education.degreeName", target = "educationalQualification"),
            @Mapping(source = "address.city", target = "residentialCity"),
            @Mapping(source = "address.country", target = "residentialCountry"),
            @Mapping(source = "employment", target = ".")
    })
    PersonDTO convert(BasicUser basicUser, Education education, Address address, Employment employment);

}
