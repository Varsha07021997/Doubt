package com.restful.webservices.restfulwebservices.Entities.JPQL;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "Primary")
public interface EmpRepository extends CrudRepository<Emp,Integer> {
    @Query("from Emp")
    List<Emp>findAllEmp(Pageable pageable);
    //List<Emp>findAllEmp();
    @Query("select e.firstName,e.lastName from Emp e")
    List<Object[]>findAllEmpPartialData();
    @Query("from Emp where firstName=:firstName")
    List<Emp>findAllEmpByFirstName(@Param("firstName")String firstName);
    @Query("from Emp where salary>:min and salary<:max")
    List<Emp> findEmpForGivenSalary(@Param("min")int min,@Param("max")int max);

    @Modifying
    @Query("delete from Emp where firstName=:firstName")
    void deleteEmpByFirstName(@Param("firstName")String firstName);

    @Query(value = "select * from emp",nativeQuery = true)
    List<Emp>findAllEmpNQ();

    @Query(value = "select * from emp where first_name=:firstName",nativeQuery = true)
    List<Emp>findAllFirstNQ(@Param("firstName")String firstName);

    //Assignment

    /*Display the first name, last name of all employees having salary greater than average
    salary ordered in ascending by their age and in descending by their salary.*/
    @Query("select e.firstName, e.lastName from Emp e where salary>(select avg(salary) from Emp)")
    List<Object[]> findAllEmployeeAvg(Sort sort);


    /*Update salary of all employees by a salary passed as a parameter whose
    existing salary is less than the average salary.*/

    //First find avg of salary
    @Query("select avg(salary) from Emp")
    int findAvgSal();

    @Modifying
    @Query("update Emp set salary =:salary where salary < :avgsalary")
    void updateSalaryEmpLessThanAvg(@Param("salary")int salary,@Param("avgsalary")int avgsalary);

    //Delete all employees with minimum salary.

    @Query("select min(salary) from Emp")
    int findMinSal();

    @Modifying
    @Query("delete from Emp where salary = :minSalary")
    void deleteEmpWithMinSal(@Param("minSalary")int salary);


    //Native SQL Query
    //Display the id, first name, age of all employees where last name ends with "singh"

//    @Query(value = "select emp_id,emp_first_name,emp_age from emp where emp_last_name like 'Singh'",nativeQuery = true)
//    List<Object[]>findAllEmpWithSingh();


}
