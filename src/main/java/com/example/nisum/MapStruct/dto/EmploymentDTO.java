package com.example.nisum.MapStruct.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class EmploymentDTO {

    private String deptName;
    private String deptId;
    private String orgName;
}
