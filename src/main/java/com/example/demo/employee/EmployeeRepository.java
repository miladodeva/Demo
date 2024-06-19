package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e from Employee e where e.ssn = ?1")
    Optional<Employee> findEmpoyeeBySSN(Long SSN);

    @Query("SELECT e from Employee e where e.birthDate = ?1")
    List<Employee> findEmpoyeeByBDay(LocalDate birthDay);

}