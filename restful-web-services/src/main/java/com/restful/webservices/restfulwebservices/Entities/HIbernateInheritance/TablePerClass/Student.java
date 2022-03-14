package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.TablePerClass;

import javax.persistence.Entity;

@Entity
public class Student extends School
    {
        private int fees;


        public int getFees() {
            return fees;
        }

        public void setFees(int fees) {
            this.fees = fees;
        }
    }
