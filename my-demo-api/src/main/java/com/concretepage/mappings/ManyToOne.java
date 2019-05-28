/*package com.concretepage.mappings;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.concretepage.controller.PersonController;
import com.concretepage.entity.Course;
import com.concretepage.entity.Person;
import com.concretepage.service.PersonService;

						// Not working. Line 25 throwing null pointer exception error. why??

@Repository
@Transactional
public class ManyToOne {
	
//	@Autowired
	//private static  PersonService personService;
	//@PersistenceContext
	private static EntityManager em;	
	
	@Autowired private static PersonController controller;

	public static void main(String args[]) {
		
		//get person from DB
		int id=1;

		PersonController personController = new PersonController();
		controller.getPersonIDDetailsWithoutApi(id);
		Person tempPerson=em.find(Person.class, id);		//em is coming null. not the correct configuration
		System.out.println("/n person is "+tempPerson);
		
		//create courses
		Course t1=new Course("english");
		Course t2=new Course("hindi");
		
		//add course to a particular person..... i.e. many to one relation
		tempPerson.add(t1);
		tempPerson.add(t2);
		
		//save courses........then will save particular person with them
		em.persist(t1);
		em.persist(t2);
		
		System.out.println("\n\nsaving person and courses by ManyToOne "+tempPerson+"/n"+t1+"/n"+t2+"\n\n");
		
		//now retrieving the associated courses from a particular person... i.e. verifying one to many relation
		System.out.println("for person "+tempPerson+" its courses are "+tempPerson.getCourses()+"/n");
	}

}*/