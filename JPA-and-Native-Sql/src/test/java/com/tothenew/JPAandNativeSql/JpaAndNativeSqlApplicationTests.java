package com.tothenew.JPAandNativeSql;

import com.tothenew.JPAandNativeSql.entities.Employee;
import com.tothenew.JPAandNativeSql.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class JpaAndNativeSqlApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreate(){
		Employee employee = new Employee();
		employee.setFirstName("riya");
		employee.setLastName("sharma");
		employee.setSalary(55000);
		employee.setAge(29);
		repository.save(employee);
	}

	//Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
	@Test
	void testFindAllEmployeePartially(){
		List<Object[]> objects = repository.findAllEmployeePartially(35000);
		for(Object[] object:objects){
			System.out.println(object[0]);
			System.out.println(object[1]);
		}
	}

	//Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
	@Test
	@Transactional
	@Rollback(value = false)
	void testUpdateEmployeeBySalary(){
		repository.updateEmployeeBySalary(5000,35000);
	}

	//Delete all employees with minimum salary.
	@Test
	@Transactional
	@Rollback(value = false)
	void testDeleteEmployeeWithMinimumSalary(){
		repository.deleteEmployeeWithMinimumSalary(30000);
	}

	//Display the id, first name, age of all employees where last name ends with "singh"
	@Test
	void testFindAllEmployeeWithLastNameSingh(){
		List<Employee> employees =  repository.findAllEmployeeWithLastNameSingh();
		for(Employee employee:employees){
			System.out.println(employee);
		}
	}

	//Delete all employees with age greater than 45(Should be passed as a parameter)
	@Test
	@Transactional
	@Rollback(value = false)
	void testDeleteAllEmployeeAgeMoreThan(){
		repository.deleteAllEmployeeAgeMoreThan(45);
	}

}
