package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.TablePerClass;

import javax.persistence.Entity;

@Entity
public class Staff extends School
{
    private int sal;

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }
}
