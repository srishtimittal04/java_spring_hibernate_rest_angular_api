package com.concretepage.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concretepage.entity.Person;
import com.concretepage.service.PersonService;

//stereotype for presentation layer (spring-MVC) from @component in spring
@RestController		//class annotation indicates that the results of all methods declared in this class will be bound to the response body by default
@RequestMapping("person")
public class PersonController {
	@Autowired
	private  PersonService service;
	
	@GetMapping(value="details")
	public List<Person> getPersonDetails() {
	//	List<Person> persons = new ArrayList<>();
	//	return persons;
		return service.getAllData();
 	}
	
	@GetMapping(value="details/{id}")
	public Person getPersonIDDetails(@PathVariable(value="id") int ID) {
			return service.getIdDetails(ID);
 	}
	
	@PostMapping(value="create")						//catching data from js UI or ARC extension
	public void createPerson(@Valid @RequestBody Person person) {	
		System.out.println("----------------- "+person);
		//throw new Exception("error.................");			//forcefully throws exception
		service.createPerson(person);	
 	}
	
	@PutMapping(value="update")
	public void updateDetails(@RequestBody Person person) {
		int id=person.getId();
		String name=person.getName();
		String city=person.getCity();
		
		Person pWithID=service.getIdDetails(id);
		pWithID.setName(name);
		pWithID.setCity(city);
		
		service.updatePerson(pWithID);
	}
	
	@DeleteMapping(value="delete/{id}")
	public void deletePerson(@PathVariable(value="id") int ID) {
		service.deletePersonID(ID);
 	}
	
	@ExceptionHandler(Exception.class)					//study from https://www.baeldung.com/spring-response-entity
	  public ResponseEntity<Exception> assertionException(final Exception e) {
		 HttpHeaders headers = new HttpHeaders();
		 System.out.println("\n////////////Error//////////////\n"+e.getMessage());
		// e.printStackTrace();
		 return new ResponseEntity<Exception>(e, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		 								//returns INTERNAL_SERVER_ERROR or 500 BAD REQUEST(when goes to validation class)
	  }
	 
}
