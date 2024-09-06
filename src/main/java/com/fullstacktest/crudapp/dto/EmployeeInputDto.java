package com.fullstacktest.crudapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fullstacktest.crudapp.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeInputDto {

    String name;

    String phoneNumber;

    String gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate dateOfBirth;
}
