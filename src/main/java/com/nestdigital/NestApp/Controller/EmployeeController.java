package com.nestdigital.NestApp.Controller;

import com.nestdigital.NestApp.Dao.EmployeeDao;
import com.nestdigital.NestApp.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/addEmployee",consumes = "application/json",produces = "application/json")
    public String addemployee(@RequestBody EmployeeModel employee){
        dao.save(employee);
        return "success";
    }

     @CrossOrigin(origins = "*")
    @GetMapping(path="/viewEmployee")
    public List<EmployeeModel> viewemployee(@RequestBody EmployeeModel view){
        return (List<EmployeeModel>) dao.findAll();

     }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/searchEmployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> searchemployee(@RequestBody EmployeeModel search){
        return (List<EmployeeModel>) dao.searchEmployee(search.getName(),search.getEmp_code());
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path="/deleteEmployee",consumes = "application/json",produces = "application/json")
    public String deletemployee(@RequestBody EmployeeModel delete){
        dao.deleteById(delete.getId());
        return "success";

    }


}
