package com.restful.webservices.restfulwebservices.Bean;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.*;

public class Employee {
    @NotNull@Min(value = 18,message = "Age should be greater than 18 and less than 100")@Max(value = 100,message ="Age should be greater than 18 and less than 100")
    private Integer age;
    @Size(min=2,message = "Name should have minimum 2 letters")
    private String name;
    private Integer id;
    protected Employee() {   }

    @Override
    public String toString() {
        return String.format("User [id = %s ,name = %s, age = %s]",id,name,age);
    }

    public Employee(int id , String name, int age)
    {
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public void setId(int id)
    {
        this.id = id;
    }

}
