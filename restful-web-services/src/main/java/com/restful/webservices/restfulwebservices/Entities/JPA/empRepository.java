package com.restful.webservices.restfulwebservices.Entities.JPA;

import com.restful.webservices.restfulwebservices.Entities.JPA.employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

//public interface empRepository extends CrudRepository<employee,Integer> {
    public interface empRepository extends PagingAndSortingRepository<employee,Integer> {
    List<employee>findByName(String name);
    List<employee>findByNameLike(String name);
    List<employee>findByAgeBetween(int age1,int age2);


}
