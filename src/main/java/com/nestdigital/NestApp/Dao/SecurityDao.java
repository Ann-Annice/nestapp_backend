package com.nestdigital.NestApp.Dao;

import com.nestdigital.NestApp.Model.SecurityModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityModel,Integer> {


    @Query(value = "SELECT `id`, `dob`, `email`, `name`, `password`, `place` FROM `security` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<SecurityModel> securityLogin(String email,String password);
}
