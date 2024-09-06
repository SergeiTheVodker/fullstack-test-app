package com.fullstacktest.crudapp.controller;

import com.fullstacktest.crudapp.enums.Gender;
import com.fullstacktest.crudapp.model.Employee;
import com.fullstacktest.crudapp.dto.EmployeeInputDto;
import com.fullstacktest.crudapp.dto.EmployeeResponseDto;
import com.fullstacktest.crudapp.repository.EmployeeRepository;
import jakarta.persistence.EnumType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EmployeesController {

    private final EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployee")
    @ResponseBody
    public EmployeeResponseDto createEmployee(@RequestBody EmployeeInputDto requestInput){
        Employee employee = new Employee(requestInput.getName(), requestInput.getPhoneNumber(),
                Gender.valueOf(requestInput.getGender()), requestInput.getDateOfBirth());
        employeeRepository.save(employee);
        return new EmployeeResponseDto(employee.getId());
    }

    @GetMapping("/fizzBuzz")
    public ResponseEntity getFizzBuzz(@RequestParam Integer numberInput){
        String returnText = "";
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Custom-Header","localhost 8080 FizzBuzzEndpoint");
        try{
            if(numberInput <= 100){
                if(numberInput % 3 == 0){
                    returnText = returnText + "Fizz";
                }

                if(numberInput % 5 == 0){
                    returnText = returnText + "Buzz";
                }

                if(((numberInput % 3 != 0) && (numberInput % 5 != 0))){
                    returnText = numberInput.toString();
                }
            }
        }catch(NumberFormatException e){
            throw new NumberFormatException("Not a number less than 100!");
        }
        return ResponseEntity.ok().headers(responseHeaders).body(returnText);
    }

    @GetMapping("/getEmployees")
    public ResponseEntity getEmployees(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Custom-Header","localhost 8080 getEmployees endpoint");
        return ResponseEntity.ok().headers(responseHeaders).body(employeeRepository.findAll());
    }
}
