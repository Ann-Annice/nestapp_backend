package com.nestdigital.NestApp.Controller;

import com.nestdigital.NestApp.Dao.EmployeeDao;
import com.nestdigital.NestApp.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/addEmployee",consumes = "application/json",produces = "application/json")
    public String addemployee(@RequestBody EmployeeModel employee){
        dao.save(employee);
        return "test";
    }


}
