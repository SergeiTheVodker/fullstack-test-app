package com.fullstacktest.crudapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fullstacktest.crudapp.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String name;

    String phoneNumber;

    Gender gender;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate dateOfBirth;

    public Employee(String name, String phoneNumber, Gender gender,
                    LocalDate dateOfBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
}
