package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.PersonDAO;
import com.concretepage.entity.Person;

//model in MVC is DAO(where data manipulation is done) and POJO(entity bean)
@Service	//used to annotated classes which hold business logic in the Service layer
public class PersonService {
	@Autowired
	private PersonDAO personDAO;

	public void createPerson(Person person) {
		personDAO.createPerson(person);
	}
	
	public List<Person> getAllData() {
		return personDAO.getAllPersons();
	}
	
	public Person getIdDetails(int ID) {
		return personDAO.personWithID(ID);
	}
	
	public void updatePerson(Person person) {
		personDAO.update(person);
	}
	
	public void deletePersonID(int ID) {
		personDAO.delete(ID);
	}
}