package com.restful.webservices.restfulwebservices.Controller;

import com.restful.webservices.restfulwebservices.Bean.Employee;
import com.restful.webservices.restfulwebservices.Service.EmployeeDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private EmployeeDaoService service;

    //WE use /GET /users to RetriveAllUsers
    @GetMapping("/allEmployee")
    public List<Employee> retriveAllEmployee()
    {
        return service.findAll();
    }    //Output can be get as http://localhost:8080/allEmployee

    //WE use /GET /users/{id} to Retrive a specific User
    @GetMapping("/Employee/{id}")
    public Employee retriveOneEmployee(@PathVariable int id)
    {
        Employee emp = service.findOne(id);
        if(emp==null)
            throw new EmployeeNotFoundException("id -"+id);
        return emp;
    }    //Output can be retrived as http://localhost:8080/Employee/1

    @PostMapping("/Employee")
    public ResponseEntity<Object> createEmp(@Valid @RequestBody Employee employee)
    {

    Employee emp=service.save(employee);
    URI location=ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(emp.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/Employee/{id}")
    public void deleteEmployee(@PathVariable int id)
    {
        Employee emp = service.deleteById(id);
        if(emp==null)
            throw new EmployeeNotFoundException("id -"+id);
    }

    @PutMapping("update-employee/{id}")
    public Employee updateEmployees(@RequestBody Employee employee,@PathVariable int id)
    {
        service.updateData(employee,id);
        return employee;
    }

    //Internationalization
    @GetMapping("/messages-internationalized/{name}")
    public String msg(@PathVariable String name ,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        return messageSource.getMessage("good.morning.message", null,locale)+" " +name;
    }


//Using hateoas and creating a link to get all users
    @GetMapping("linkEmp/{id}")
    public EntityModel<Employee> specificEmployee(@PathVariable int id){
        Employee one = service.findOne(id);
        if(one == null){
            throw new EmployeeNotFoundException("id :"+id);
        }
        EntityModel<Employee> resource = EntityModel.of(one);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retriveAllEmployee());
        resource.add(linkTo.withRel("all-employees"));
        return resource;

    }
}
