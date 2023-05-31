package com.example.nisum.MapStruct.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@ToString
public class PersonDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String educationalQualification;
    private String residentialCity;
    private String residentialCountry;
    private String designation;
    private long salary;
    private EducationDTO education;
    private List<ManagerDTO> managerList;
    private List<EmploymentDTO> employmentDTOS;

    public List<ManagerDTO> getManagerList() {
        return managerList;
    }

    public void setManagerList(List<ManagerDTO> managers) {
        this.managerList = managers;
    }

    public void addManagerList(ManagerDTO managerDTO) {
        if (managerList == null) {
            managerList = new ArrayList<>();
        }

        managerList.add(managerDTO);
    }

}
