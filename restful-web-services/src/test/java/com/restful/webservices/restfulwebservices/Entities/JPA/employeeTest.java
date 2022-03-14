package com.restful.webservices.restfulwebservices.Entities.JPA;

import com.restful.webservices.restfulwebservices.Entities.JPA.empRepository;
import com.restful.webservices.restfulwebservices.Entities.JPA.employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class employeeTest {

    @Autowired
    empRepository empRepo;

    @Test
    public void contextLoads(){

    }
    @Test
    public void testCreate(){
        employee emp=new employee();
        employee emp2=new employee();
        emp.setId(1);
        emp.setName("Varsha");
        emp.setAge(25);
        emp.setLocation("Delhi");
        emp2.setId(2);
        emp2.setName("Shruti");
        emp2.setAge(27);
        emp2.setLocation("Kanpur");
        empRepo.save(emp2);
        empRepo.save(emp);

    }
    @Test
    public void testRead()
    {
        employee e=empRepo.findById(1).get();
        assertNotNull(e);
        assertEquals("Varsha",e.getName());
        System.out.println("=======AGE======="+e.getAge());
    }
    @Test
    public void testUpdate()
    {
        employee e=empRepo.findById(1).get();
        e.setAge(24);
        empRepo.save(e);
    }
    @Test
    public void testDelete()
    {
       if(empRepo.existsById(1))
        empRepo.deleteById(1);
    }
    @Test
    public void testCount()
    {
        System.out.println("Total number of records are :  "+empRepo.count());
    }
    @Test
    public void testFindByName()
    {
        List<employee> list=empRepo.findByName("Varsha");
        list.forEach(e-> System.out.println("Employee ID :"+e.getId()+"   Employee Name :"+e.getName()));
    }

    @Test
    public void testFindByAgeBetween()
    {
        List<employee> list=empRepo.findByAgeBetween(28,32);
        System.out.println("=========Employees between 28 and 32 are :=========");
        list.forEach(e-> System.out.println(e.getName()));
    }
    @Test
    public void testFindByNameLike()
    {
        List<employee> list=empRepo.findByNameLike("A%");
        System.out.println("=========Employees whose name starts with A are :=========");
        list.forEach(e-> System.out.println(e.getName()));
    }
    @Test
 public void testFindAllPaging()
    {
        //Here page is page number and size is how many records we want to display
        Pageable pageable=PageRequest.of(0,2);
        Page<employee> res=empRepo.findAll(pageable);
        res.forEach(e-> System.out.println(e.getId()+"    "+e.getName()+"    "+ e.getAge()+"    "+e.getLocation()));

    }

    @Test
    public void testFindAllSorting()
    {
        empRepo.findAll(Sort.by("age")).forEach(e-> System.out.println(e.getId()+"    "+e.getAge()+"    "+e.getName() +"    "+e.getLocation()));

    }
    @Test
    public void testFindAllPagingAndSort()
    {
        Pageable pageable=PageRequest.of(0,3, Sort.by(Sort.Order.asc("age"),Sort.Order.desc("Id")));
        Page<employee> res=empRepo.findAll(pageable);
        res.forEach(e-> System.out.println(e.getId()+"    "+e.getAge()+"    "+e.getName() +"    "+e.getLocation()));

    }

}