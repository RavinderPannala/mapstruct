package com.example.nisum.MapStruct.mapper;

import com.example.nisum.MapStruct.enums.DegreeStream;
import com.example.nisum.MapStruct.enums.DegreeStreamPrefix;
import com.example.nisum.MapStruct.enums.DesignationCode;
import com.example.nisum.MapStruct.enums.DesignationConstant;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnumMapper {

    EnumMapper enumMapper = Mappers.getMapper(EnumMapper.class);

    @ValueMappings({
            @ValueMapping(source = "CEO", target = "CHIEF_EXECUTIVE_OFFICER"),
            @ValueMapping(source = "CTO", target = "CHIEF_TECHNICAL_OFFICER"),
            @ValueMapping(source = "VP", target = "VICE_PRESIDENT"),
            @ValueMapping(source = "SM", target = "SENIOR_MANAGER"),
            @ValueMapping(source = "M", target = "MANAGER"),
            @ValueMapping(source = "ARCH", target = "ARCHITECT"),
            @ValueMapping(source = "SSE", target = "SENIOR_SOFTWARE_ENGINEER"),
            @ValueMapping(source = "SE", target = "SOFTWARE_ENGINEER"),
            @ValueMapping(source = "INT", target = "INTERN"),
            @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "OTHERS"),
            @ValueMapping(source = MappingConstants.NULL, target = "OTHERS")
    })
    DesignationConstant convert(DesignationCode code);

    @EnumMapping(nameTransformationStrategy = "prefix", configuration = "MSC_")
    DegreeStreamPrefix convert(DegreeStream degreeStream);

    @EnumMapping(nameTransformationStrategy = "stripPrefix", configuration = "MSC_")
    DegreeStream convert(DegreeStreamPrefix degreeStreamPrefix);
}
