package com.tothenew.JPAandNativeSql.repos;

import com.tothenew.JPAandNativeSql.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query("select firstName, lastName from Employee where salary>:avg_sal order by age asc, salary desc")
    List<Object[]> findAllEmployeePartially(@Param("avg_sal") double avg_sal);

    @Modifying
    @Query("update Employee set salary=salary+:increment where salary<:avg_sal")
    void updateEmployeeBySalary(@Param("increment")double increment, @Param("avg_sal") double avg_sal);

    @Modifying
    @Query("delete from Employee where salary<:min_sal")
    void deleteEmployeeWithMinimumSalary(@Param("min_sal")double min_sal);

    @Query(value = "select * from employee_table where emp_last_name='Singh'",nativeQuery = true)
    List<Employee> findAllEmployeeWithLastNameSingh();

    @Modifying
    @Transactional
    @Query(value = "delete from employee_table where emp_age>:age",nativeQuery = true)
    void deleteAllEmployeeAgeMoreThan(@Param("age") int age);
}
