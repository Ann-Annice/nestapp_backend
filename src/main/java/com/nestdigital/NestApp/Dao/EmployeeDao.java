package com.nestdigital.NestApp.Dao;

import com.nestdigital.NestApp.Model.EmployeeModel;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {
}
