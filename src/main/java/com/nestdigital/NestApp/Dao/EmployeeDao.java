package com.nestdigital.NestApp.Dao;

import com.nestdigital.NestApp.Model.EmployeeModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `address`, `designation`, `dob`, `email`, `emp_code`, `joining_date`, `name`, `password` FROM `employees` WHERE `emp_code`=:emp_code OR `name`=:name",nativeQuery = true)
    List<EmployeeModel> searchEmployee(String name,String emp_code);

    @Modifying
    @Query(value = "DELETE FROM `employees` WHERE `id`=:id",nativeQuery = true)
    void deleteById(Integer id);


    @Modifying
    @Query(value = "UPDATE `employees` SET `id`=:id,`address`=:address,`designation`=:designation,`dob`=:dob,`email`=:email,`emp_code`=:emp_code,`joining_date`=:joining_date,`name`=:name,`password`=:password WHERE `id`=:id",nativeQuery = true)
    void updateEmployee(String name,String address,String emp_code,String designation,String dob,String email,String password,String joining_date,Integer id);

    @Query(value = "SELECT `id`, `address`, `designation`, `dob`, `email`, `emp_code`, `joining_date`, `name`, `password` FROM `employees` WHERE `email`=:email AND `password`=:password",nativeQuery = true)
    List<EmployeeModel> employeeLogin(String email,String password);
}
