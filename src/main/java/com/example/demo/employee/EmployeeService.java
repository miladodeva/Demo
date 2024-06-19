package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getEmployees() throws ParseException {
        return employeeRepository.findAll();
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

    public String addNewEmployee(Employee employee, Integer departmentNumber) throws ParseException {
        String message = "Employee added successfully";
        Optional<Employee> employeeOptional = employeeRepository.findEmpoyeeBySSN(employee.getSsn());
        Optional<Department> optDepartment = departmentRepository.findById(departmentNumber);
        Department department = optDepartment.orElse(new Department());
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException("Eployee with that SSN already exists");
        }
        if (optDepartment.isPresent()) {
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
        //System.out.println(employee);
        return message;
    }

    public String deleteEmployeeBySSN(Long employeeSSN) throws ParseException {
        String message = "Employee was deleted successfully";
        boolean exists = employeeRepository.existsById(employeeSSN);
        if (!exists) {
            throw new IllegalStateException("Employee with id " + employeeSSN + " does not exist");
        }
        employeeRepository.deleteById(employeeSSN);
        return message;
    }

    public List<Employee> getEmployeesBySalary(Integer salary) throws ParseException {
        List<Employee> allEmployees = employeeRepository.findAll();
        List<Employee> employeesBySalary = new ArrayList<>();
        if (!allEmployees.isEmpty()) {
            for (Employee employee : allEmployees) {
                if (employee.getSalary().equals(salary)) {
                    employeesBySalary.add(employee);
                }
            }
        } else {
            throw new IllegalStateException("Employee list is empty");
        }
        if (employeesBySalary.isEmpty()) {
            throw new IllegalStateException("There are no employees with that salary");
        }
        return employeesBySalary;
    }

    public List<Employee> getEmployeesByBday(LocalDate birthDay) throws ParseException {
        List<Employee> allEmployees = employeeRepository.findEmpoyeeByBDay(birthDay);
        if (allEmployees.isEmpty()) {
            throw new IllegalStateException("There are no employees wit that birthDay");
        }
        return allEmployees;
    }

    public List<EmployeeDTO> getEmployeeDto() {
        return employeeRepository.findAll().stream().map(Employee::mapToDto).toList();
    }

    public List<Employee> filterEmployeesBySalary(Integer minSalary, Integer maxSalary) {
        return employeeRepository.findAll().stream()
                .filter(employee -> employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary)
                .collect(Collectors.toList());
    }

    public String updateEmployee(Long employeeSSN, String firstName, String lastName, String address, Integer salary) throws ParseException {
        String message = "There was no update!";
        Employee employee = employeeRepository.findById(employeeSSN).orElseThrow(
                () -> new IllegalStateException("Employee with id " + employeeSSN + " does not exist"));
        if (firstName != null && firstName.length() > 0 && !Objects.equals(firstName, employee.getFirstName())) {
            message = "First name was successfully updated!";
            employee.setFirstName(lastName);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(lastName, employee.getLastName())) {
            message = "Last name was successfully updated!";
            employee.setLastName(lastName);
        }
        if (address != null && address.length() > 0 && !Objects.equals(address, employee.getAddress())) {
            message = "Address was successfully updated!";
            employee.setAddress(address);
        }
        if (salary != null && salary > 0 && !Objects.equals(salary, employee.getAddress())) {
            message = "Salary was successfully updated!";
            employee.setSalary(salary);
        }
        employeeRepository.save(employee);
        return message;
    }

}
