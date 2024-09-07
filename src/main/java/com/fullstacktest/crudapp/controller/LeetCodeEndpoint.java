package com.fullstacktest.crudapp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//TODO: add your leetcode answers here.
@RestController
public class LeetCodeEndpoint {
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
}
