package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable;

import com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.SingleTable.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "Primary")
public interface PaymentRepository extends CrudRepository<Payment,Integer> {

}
