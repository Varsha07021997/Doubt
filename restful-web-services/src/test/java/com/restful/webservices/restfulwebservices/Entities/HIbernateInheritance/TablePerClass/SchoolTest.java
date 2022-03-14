package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.TablePerClass;

import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable.CreditCard;
import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class SchoolTest {
    @Autowired
    SchoolRepository schoolRepository;
    @Test
    public void createStaff()
    {
        Staff staff=new Staff();
        staff.setId(1);
        staff.setName("Priya");
        staff.setSal(12000);
        schoolRepository.save(staff);
    }
    @Test
    public void createStudent()
    {
        Student student=new Student();
        student.setId(200);
        student.setName("Ayush");
        student.setFees(6000);
        schoolRepository.save(student);
    }

}