package com.example.nisum.MapStruct.mapper;

import com.example.nisum.MapStruct.dto.EducationDTO;
import com.example.nisum.MapStruct.dto.EmploymentDTO;
import com.example.nisum.MapStruct.model.Education;
import com.example.nisum.MapStruct.model.Employment;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Mapper
public interface CollectionMapper {

    CollectionMapper INSTANCE = Mappers.getMapper(CollectionMapper.class);

    Set<String> convert(Set<Long> ids);

    //no need to declare
    Set<EmploymentDTO> convertEmployment(Set<Employment> employmentSet);

    //We have declare manually for List and stream
    @Mappings({
            @Mapping(source = "education.degreeName", target = "degree"),
            @Mapping(source = "education.institute", target = "college"),
            @Mapping(source = "education.yearOfPassing", target = "passingYear")
    })
    EducationDTO convertEducation(Education education);

    List<EducationDTO> convertEducation(List<Education> education);

    //Map
    @MapMapping(keyNumberFormat = "#L", valueDateFormat = "dd.MM.yyyy")
    Map<String, String> map(Map<Long, Date> dateMap);

    //Stream
    List<EducationDTO> convertEducation(Stream<Education> educationStream);

}
