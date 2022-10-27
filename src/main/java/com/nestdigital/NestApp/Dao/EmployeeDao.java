package com.nestdigital.NestApp.Dao;

import com.nestdigital.NestApp.Model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `designation`, `dob`, `email`, `emp_code`, `name`, `password` FROM `employees` WHERE `emp_code`=:emp_code OR `name`=:name",nativeQuery = true)
    List<EmployeeModel> searchEmployee(String name,String emp_code);

    @Modifying
    @Query(value = "DELETE FROM `employees` WHERE `id`=:id",nativeQuery = true)
    void deleteById(Integer id);
}
