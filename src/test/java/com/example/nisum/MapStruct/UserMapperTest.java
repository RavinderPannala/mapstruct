package com.example.nisum.MapStruct;

import com.example.nisum.MapStruct.model.Address;
import com.example.nisum.MapStruct.dto.BasicUserDto;
import com.example.nisum.MapStruct.model.Education;
import com.example.nisum.MapStruct.dto.PersonDTO;
import com.example.nisum.MapStruct.mapper.BasicMapper;
import com.example.nisum.MapStruct.model.BasicUser;
import com.example.nisum.MapStruct.model.Manager;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.bind.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserMapperTest {

    private BasicMapper basicMapper = Mappers.getMapper(BasicMapper.class);

    @Test
    public void convertBasicUserToBasicUserDTO() {
        BasicUser basicUser = BasicUser.builder().id(1).name("Ravinder").build();
        BasicUserDto basicUserDto = basicMapper.convert(basicUser);

        assertEquals(basicUser.getName(), basicUserDto.getName());
        assertEquals(basicUser.getId(), basicUserDto.getId());
    }

    @Test
    public void convertBasicUserDTOToBasicUser() {
        BasicUserDto basicUserDto = BasicUserDto.builder().id(1).name("Ravinder").build();
        BasicUser basicUser = basicMapper.convert(basicUserDto);

        assertEquals(basicUserDto.getName(), basicUser.getName());
        assertEquals(basicUserDto.getId(), basicUser.getId());
    }

    @Test
    public void convertBasicUserToPersonDTO() {
        BasicUser basicUser = BasicUser.builder().id(1).name("Ravinder Pannala").build();
        PersonDTO personDTO = basicMapper.convertCustom(basicUser);

        assertEquals(String.valueOf(basicUser.getId()), personDTO.getId());
        assertNotNull(personDTO.getLastName());
        assertNotNull(personDTO.getFirstName());
    }

    @Test
    public void convertUserEducationAddToPersonDTO() {
        BasicUser basicUser = BasicUser.builder().id(2).name("Ravinder Pannala").build();
        Education education = Education.builder().degreeName("MHVR").build();
        Address address = Address.builder().city("Hyd").state("TG").build();

        PersonDTO personDTO = basicMapper.convert(basicUser, education, address);

        assertEquals(basicUser.getName(), personDTO.getFirstName());
        assertEquals(address.getCity(), personDTO.getResidentialCity());
        assertEquals(education.getDegreeName(), personDTO.getEducationalQualification());
    }

    @Test
    public void convertManagersListToPersonDTO() {
        Manager manager = Manager.builder().id(1).name("VEN").build();
        BasicUser basicUser = BasicUser.builder().id(2).name("Ravinder Pannala").managerList(Arrays.asList(manager)).build();
        Education education = Education.builder().degreeName("MHVR").build();
        Address address = Address.builder().city("Hyd").state("TG").build();

        PersonDTO personDTO = basicMapper.convert(basicUser, education, address);

        assertEquals(basicUser.getManagerList().size(), personDTO.getManagerList().size());
        assertEquals(basicUser.getManagerList().get(0).getName(), personDTO.getManagerList().get(0).getName());
    }

}
