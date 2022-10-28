package com.nestdigital.NestApp.Dao;

import com.nestdigital.NestApp.Model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel,Integer> {

    @Query(value = "SELECT p.`id`, p.`emp_code`, p.`login_sec_id`, p.`login_time`, p.`logout_sec_id`, p.`logout_time`,e.name FROM `logs` p JOIN employees e ON p.emp_code=e.emp_code",nativeQuery = true)
    List<Map<String,String>> viewall();


    @Query(value = "SELECT p.`id`, p.`emp_code`, p.`login_sec_id`, p.`login_time`, p.`logout_sec_id`, p.`logout_time`,e.name FROM `logs` p JOIN employees e ON p.emp_code=e.emp_code WHERE p.emp_code=:emp_code",nativeQuery = true)
    List<Map<String,String>> viewsingle(String emp_code);


    @Modifying
    @Query(value = "UPDATE `logs` SET `logout_sec_id`=:logout_sec_id,`logout_time`=:logout_time WHERE `emp_code`=:emp_code",nativeQuery = true)
    void updateLogDetails(String logout_time,int logout_sec_id,String emp_code);
}
