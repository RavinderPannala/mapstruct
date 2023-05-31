package com.example.nisum.MapStruct.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class BasicUserDto {

    private int id;
    private String name;

}
