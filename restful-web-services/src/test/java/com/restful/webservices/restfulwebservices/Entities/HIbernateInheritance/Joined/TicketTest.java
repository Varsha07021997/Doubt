package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.Joined;

import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.TablePerClass.SchoolRepository;
import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.TablePerClass.Staff;
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
    class TicketTest {
        @Autowired
        TicketRepository ticketRepository;
        @Test
        public void createDebit()
        {
            DebitCard debitCard=new DebitCard();
            debitCard.setId(60);
            debitCard.setDebitcardnumber("qwerty123");
            debitCard.setAmount(3000);
            ticketRepository.save(debitCard);
        }
        @Test
        public void createUpi()
        {
            Upi upi=new Upi();
            upi.setId(205);
            upi.setUpi("varsha07@okisbi");
            upi.setAmount(9000);
            ticketRepository.save(upi);
        }

}