package com.nestdigital.NestApp.Controller;

import com.nestdigital.NestApp.Dao.LeaveDao;
import com.nestdigital.NestApp.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeave",consumes = "application/json",produces = "application/json")
    public String addleave(@RequestBody LeaveModel add){
        dao.save(add);
        return "success";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewall")
    public List<Map<String,String>> viewall(@RequestBody LeaveModel viewall){
        return (List<Map<String, String>>) dao.viewall();

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/view",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> view(@RequestBody LeaveModel view){
        return (List<Map<String, String>>) dao.view(view.getEmp_code());

    }
}
