<<<<<<< HEAD
package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @RequestMapping(path = "/getDepartments")
    public List<Department> getDepartments() throws ParseException {
        return departmentService.getDepartments();
    }

    @PostMapping
    @RequestMapping(path = "/registerNewDepatment")
    public String registerNewDepartment(@RequestBody Department department) throws ParseException {
        String message = departmentService.addNewDepartment(department);
        return message;
    }

}
=======
package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "departments")
public class DepartmentController {


    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @RequestMapping(path = "/getDepartments")
    public List<Department> getDepartments() throws ParseException {
        return departmentService.getDepartments();
    }

    @PostMapping
    @RequestMapping(path = "/registerNewDepatment")
    public String registerNewDepartment(@RequestBody Department department) throws ParseException {
        String message = departmentService.addNewDepartment(department);
        return message;
    }

}
>>>>>>> 347a7ef072895612847d2a67a504088139ce1ef4
