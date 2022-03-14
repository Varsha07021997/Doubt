package com.restful.webservices.restfulwebservices.Entities.JPQL;

import javax.persistence.*;

@Entity
@Table
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="empId")
    private Integer id;
    @Column(name="empSalary")
    private int salary;
    @Column(name ="empAge")
    private int age;
    @Column(name="empFirstName")
    private String firstName;
    @Column(name="empLastName")
    private String lastName;

    public Emp(){

    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", salary=" + salary +
                ", age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Emp(Integer id, int salary, int age, String firstName, String lastName) {
        this.id = id;
        this.salary = salary;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
