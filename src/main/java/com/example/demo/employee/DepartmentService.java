<<<<<<< HEAD
package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public String addNewDepartment(Department department) throws ParseException {
        String message = "Department added successfully";
        Optional<Department> newDepartment = departmentRepository.findById(department.getId());
        if (newDepartment.isPresent()) {
            throw new IllegalStateException("Department with that id already exists");
        }
        departmentRepository.save(department);
        System.out.println(department);
        return message;
    }

    public List<Department> getDepartments() throws ParseException {
        return departmentRepository.findAll();
//        LocalDate date = LocalDate.of(2000, 1, 8);
//        return List.of(new Employee(25563955L,
//                date,
//                10,
//                300000,
//                "M",
//                "V.S.Bato",
//                "Stojanova",
//                "Angela"));
    }

}
=======
package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public String addNewDepartment(Department department) throws ParseException {
        String message = "Department added successfully";
        Optional<Department> newDepartment = departmentRepository.findById(department.getId());
        if (newDepartment.isPresent()) {
            throw new IllegalStateException("Department with that id already exists");
        }
        departmentRepository.save(department);
        System.out.println(department);
        return message;
    }

    public List<Department> getDepartments() throws ParseException {
        return departmentRepository.findAll();
//        LocalDate date = LocalDate.of(2000, 1, 8);
//        return List.of(new Employee(25563955L,
//                date,
//                10,
//                300000,
//                "M",
//                "V.S.Bato",
//                "Stojanova",
//                "Angela"));
    }

}
>>>>>>> 347a7ef072895612847d2a67a504088139ce1ef4
