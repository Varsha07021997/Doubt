package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.Joined;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="debitcard")
@PrimaryKeyJoinColumn(name="id")
public class DebitCard extends Ticket{
    private String debitcardnumber;

    public String getDebitcardnumber() {
        return debitcardnumber;
    }

    public void setDebitcardnumber(String debitcardnumber) {
        this.debitcardnumber = debitcardnumber;
    }
}
