package com.nestdigital.NestApp.Controller;

import com.nestdigital.NestApp.Dao.EmployeeDao;
import com.nestdigital.NestApp.Model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/addEmployee",consumes = "application/json",produces = "application/json")
    public String addemployee(@RequestBody EmployeeModel employee){
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        employee.setJoining_date(currentdate);
        System.out.println(employee.toString());
        dao.save(employee);
        return "success";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewEmployee")
    public List<EmployeeModel> viewemployee(@RequestBody EmployeeModel viewall){
        return(List<EmployeeModel>) dao.findAll();
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

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editEmployee",consumes = "application/json",produces = "application/json")
    public String editemployee(@RequestBody EmployeeModel edit){
        dao.updateEmployee(edit.getName(),edit.getAddress(),edit.getEmp_code(),edit.getDesignation(),edit.getDob(),edit.getEmail(),edit.getPassword(),edit.getJoining_date(),edit.getId());
        return "success";

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginEmployee",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> employeelogin(@RequestBody EmployeeModel login){
        return (List<EmployeeModel>) dao.employeeLogin(login.getEmail(),login.getPassword());

    }


}
