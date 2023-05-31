package com.example.nisum.MapStruct.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class BasicUser {

    private int id;
    private String name;
    private List<Manager> managerList;
}
