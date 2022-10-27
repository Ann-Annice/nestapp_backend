package com.nestdigital.NestApp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @PostMapping("/addEmployee")
    public String addemployee(){
        return "test";
    }
}
