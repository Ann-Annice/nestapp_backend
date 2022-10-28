package com.nestdigital.NestApp.Controller;

import com.nestdigital.NestApp.Dao.LogDao;
import com.nestdigital.NestApp.Model.LeaveModel;
import com.nestdigital.NestApp.Model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {

    @Autowired
    private LogDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLog",consumes = "application/json",produces = "application/json")
    public String addlog(@RequestBody LogModel add){
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        add.setLogin_time(currentdate);
        System.out.println(add.toString());
        dao.save(add);
        return "success";

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllLog")
    public List<Map<String,String>> viewlog(@RequestBody LogModel viewall){
        return (List<Map<String, String>>) dao.viewall();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewSingleLog")
    public List<Map<String,String>> viewsingle(@RequestBody LogModel view){
        return (List<Map<String, String>>) dao.viewsingle(view.getEmp_code());
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/logout",consumes = "application/json",produces = "application/json")
    public String logout(@RequestBody LogModel addlogout){
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
       addlogout.setLogout_time((String.valueOf(dt.format(now))));
       dao.updateLogDetails(addlogout.getLogout_time(),addlogout.getLogout_sec_id(),addlogout.getEmp_code());
        return "success";

    }



}
