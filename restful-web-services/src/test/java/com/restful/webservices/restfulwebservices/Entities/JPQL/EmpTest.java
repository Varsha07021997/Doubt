package com.restful.webservices.restfulwebservices.Entities.JPQL;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.Sort.Direction.ASC;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class EmpTest {
    @Autowired
    @Qualifier("Primary")
    EmpRepository empRepository;
    @Test
    public void testEmpCreate()
    {
    Emp emp1=new Emp();
    Emp emp2=new Emp();
    emp1.setFirstName("Varsha");
    emp1.setLastName("Saxena");
    emp1.setAge(25);
    emp1.setSalary(50000);
    empRepository.save(emp1);
    emp2.setFirstName("Anurag");
    emp2.setLastName("Singh");
    emp2.setAge(28);
    emp2.setSalary(20000);
    empRepository.save(emp2);
    }
    @Test
    public void testFindAllEmp()
    {
        //System.out.println(empRepository.findAllEmp());
        //Paging and Sorting
        System.out.println(empRepository.findAllEmp(PageRequest.of(0,4, Sort.Direction.ASC,"firstName")));
    }
    @Test
    public void testFindEmpPartialData()
    {
        List<Object[]> list=empRepository.findAllEmpPartialData();
        for (Object[] obj:list) {
            System.out.println(obj[0]);
            System.out.println(obj[1]);
        }
    }
    @Test
    public void testFindAllEmpByFirstName()
    {
        System.out.println(empRepository.findAllEmpByFirstName("Varsha"));
    }
    @Test
    public void testFindAllEmpSalaryBtw()
    {
        System.out.println(empRepository.findEmpForGivenSalary(20000,85000));
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteEmpByFirstName()
    {
        empRepository.deleteEmpByFirstName("Nisha");
    }

    @Test
    public void testFindAllStudentNQ()
    {
        System.out.println(empRepository.findAllEmpNQ());
    }
    @Test
    public void testFindByFirstNameNQ()
    {
        System.out.println(empRepository.findAllEmpByFirstName("Varsha"));
    }
    //Assignment

    //JPA

    /*Display the first name, last name of all employees having salary greater than average
    salary ordered in ascending by their age and in descending by their salary.*/
    @Test
    public void testFindByGreaterThanAvg(){
        Sort sort = Sort.by("age").ascending().and(Sort.by("salary").descending());
        List<Object[]> partialData = empRepository.findAllEmployeeAvg(sort);
        for(Object[] obj : partialData){
            System.out.println(obj[0]+" "+obj[1]);
        }
    }

/*Update salary of all employees by a salary passed as a parameter
 whose existing salary is less than the average salary.
 */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateSalaryLessThanAvg()
    {
        int salary=11000;
        int avg=empRepository.findAvgSal();
        //System.out.println(avg);
        empRepository.updateSalaryEmpLessThanAvg(salary,avg);
    }

    //Delete all employees with minimum salary.
    @Test
    @Transactional
    @Rollback(value = false)
    public void testDeleteEmpWithMinSal()
    {
        int minSal=empRepository.findMinSal();
        empRepository.deleteEmpWithMinSal(minSal);
    }

    //SQL NATIVE

    //Display the id, first name, age of all employees where last name ends with "singh"

//    @Test
//    public void testNameWithSingh()
//    {
//        List<Object[]> em
//    }
}