package com.example.demo.employee;

import org.aspectj.lang.annotation.DeclareWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @RequestMapping(path = "/getEmployees")
    public List<Employee> getEmployees() throws ParseException {
        return employeeService.getEmployees();
    }

    @GetMapping
    @RequestMapping(path = "/getEmployeesBySalary/{salary}")
    public List<Employee> getEmployeesBySalary(@PathVariable Integer salary) throws ParseException {
        return employeeService.getEmployeesBySalary(salary);
    }

    @GetMapping
    @RequestMapping(path = "/getEmployeesByBDay/{birthday}")
    public List<Employee> getEmployeesByBday(@PathVariable String birthday) throws ParseException {
        LocalDate bDate = LocalDate.parse(birthday);
        return employeeService.getEmployeesByBday(bDate);
    }

    @PostMapping
    @RequestMapping(path = "/registerNewEmployee/{departmentNumber}")
    public String registerNewEmployee(@RequestBody Employee employee, @PathVariable Integer departmentNumber) throws ParseException {
        String message = employeeService.addNewEmployee(employee, departmentNumber);
        return message;
    }

    @DeleteMapping(path = "deleteEmployeeBySSN/{employeeSSN}")
    public String deleteEmployeeBySSN(@PathVariable long employeeSSN) throws ParseException {
        String message = employeeService.deleteEmployeeBySSN(employeeSSN);
        return message;
    }

    @PutMapping(path = "/updateEmployee/{employeeSSN}")
    public String updateEmployee(@PathVariable("employeeSSN") long ssn,
                                 @RequestParam(required = false) String firstName,
                                 @RequestParam(required = false) String lastName,
                                 @RequestParam(required = false) String address,
                                 @RequestParam(required = false) Integer salary) throws ParseException {
        String message = employeeService.updateEmployee(ssn, firstName, lastName, address, salary);
        return message;
    }

    @GetMapping("/dto")
    public List<EmployeeDTO> getDto() {
        return employeeService.getEmployeeDto();
    }

    @GetMapping
    @RequestMapping("/getEmployeesBySalaryInRange")
    public List<Employee> getEmployeesBySalaryInRange(@RequestParam(required = false) Integer minSalary,
                                                      @RequestParam(required = false) Integer maxSalary) {
        return employeeService.filterEmployeesBySalary(minSalary, maxSalary);
    }

}
