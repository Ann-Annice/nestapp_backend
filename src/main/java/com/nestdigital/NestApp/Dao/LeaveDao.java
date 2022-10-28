package com.nestdigital.NestApp.Dao;

import com.nestdigital.NestApp.Model.LeaveModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveModel,Integer> {


    @Query(value = "SELECT  p.`id`, p.`emp_code`, p.`leave_duration`, p.`leave_status`, p.`reason`, p.`required_date`,u.name FROM `leaverecord` p JOIN `employees` u ON u.emp_code=p.emp_code",nativeQuery = true)
    List<Map<String,String>> viewall();


    @Query(value = "SELECT  p.`id`, p.`emp_code`, p.`leave_duration`, p.`leave_status`, p.`reason`, p.`required_date`,u.name FROM `leaverecord` p JOIN `employees` u ON u.emp_code=p.emp_code WHERE p.emp_code=:emp_code",nativeQuery = true)
    List<Map<String,String>> view(String emp_code);
}
