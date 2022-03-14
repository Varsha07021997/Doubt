package com.restful.webservices.restfulwebservices.Entities.HIbernateInheritance.Joined;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket,Integer> {
}
