package com.example.nisum.MapStruct.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Employment {

    private String deptName;
    private String deptId;
    private String orgName;
}
