package com.fullstacktest.crudapp.controller;

import com.fullstacktest.crudapp.dto.EmployeeInputDto;
import com.fullstacktest.crudapp.dto.EmployeeResponseDto;
import com.fullstacktest.crudapp.enums.Gender;
import com.fullstacktest.crudapp.model.Employee;
import com.fullstacktest.crudapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    public EmployeeResponseDto saveEmployees(@RequestBody EmployeeInputDto employeeInputDto){
        Employee employee = new Employee(employeeInputDto.getName(), employeeInputDto.getPhoneNumber(),
                Gender.valueOf(employeeInputDto.getGender()), employeeInputDto.getDateOfBirth());
        employeeRepository.save(employee);
        return new EmployeeResponseDto(employee.getId());
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<List<Employee>> getEmployees(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Custom-Header","localhost 8080 getEmployees endpoint");
        return ResponseEntity.ok().headers(responseHeaders).body(employeeRepository.findAll());
    }
}
