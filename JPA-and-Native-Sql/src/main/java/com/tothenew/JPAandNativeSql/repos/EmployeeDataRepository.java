package com.tothenew.JPAandNativeSql.repos;

import com.tothenew.JPAandNativeSql.entities.EmployeeData;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDataRepository extends CrudRepository<EmployeeData,Integer> {
}
