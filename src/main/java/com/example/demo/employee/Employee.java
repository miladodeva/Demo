package com.example.demo.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class Employee {

    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private @Id Long ssn;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Integer salary;
    private LocalDate birthDate;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "department", referencedColumnName = "id", insertable = true, updatable = true)
    @ManyToOne
    @JoinColumn(name = "dep_number")
    @JsonIgnore
    private Department department;

    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id")
    //private Department department;

    public Employee() {
    }

    public EmployeeDTO mapToDto() {
        return EmployeeDTO.builder()
                .address(this.getAddress())
                .firstName(this.getFirstName())
                .gender(this.getGender())
                .lastName(this.getLastName())
                .salary(this.getSalary())
                .build();
    }

    public Employee(Long ssn, LocalDate birthDate, Integer salary, String gender, String address, String lastName, String firstName, Department depNumber) {
        this.ssn = ssn;
        this.birthDate = birthDate;
        this.salary = salary;
        this.gender = gender;
        this.address = address;
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
    }

    public Long getSsn() {
        return ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", salary=" + salary +
                ", birthDate=" + birthDate +
                '}';
    }
}
