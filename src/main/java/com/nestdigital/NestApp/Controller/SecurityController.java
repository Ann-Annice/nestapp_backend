package com.nestdigital.NestApp.Controller;

import com.nestdigital.NestApp.Dao.SecurityDao;
import com.nestdigital.NestApp.Model.SecurityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addSecurity",consumes = "application/json",produces = "application/json")
    public String addsecurity(@RequestBody SecurityModel add){
        dao.save(add);
        return "success";
    }

   @CrossOrigin(origins = "*")
    @GetMapping("/viewSecurity")
    public List<SecurityModel> viewsecurity(@RequestBody SecurityModel view){
        return (List<SecurityModel>) dao.findAll();

   }

   @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginSecurity",consumes = "application/json",produces = "application/json")
    public List<SecurityModel> securitylogin(@RequestBody SecurityModel login){
        return (List<SecurityModel>) dao.securityLogin(login.getEmail(),login.getPassword());

   }
}
