package com.example.demo.employee;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Integer salary;

}
