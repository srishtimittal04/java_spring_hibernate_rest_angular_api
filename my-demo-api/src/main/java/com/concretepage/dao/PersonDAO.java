package com.concretepage.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.concretepage.entity.Person;

@Repository	//for persistence and DAO (data access) layer in component
@Transactional	//for entity manager
public class PersonDAO {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public void createPerson(Person person) {	
		em.persist(person); 		// to save like as we do in session.save(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPersons() {
		List<?> list = em.createQuery("SELECT p FROM Person p").getResultList();
		return (List<Person>) list;
	}
	
	@SuppressWarnings("unchecked")
	public Person personWithID(int ID) {
		Person person=em.find(Person.class, ID);		 // session.get(entity);
		return person;
	}
	
	public void update(Person person) {
		
		/*Person person=em.find(Person.class, ID);
		person.setName(name);
		person.setCity(city);*/
		
		em.merge(person);				//session.update(entity);
		
		/*Query query = entityManager
				.createQuery("UPDATE Student student SET student.level = 'L' "
				+ "WHERE student.id= :id");
				query.setParameter("id", 1);
				int updateCount = query.executeUpdate();
				if (updateCount > 0) {
				System.out.println("Done...");
				}*/
	}
	
	public void delete(int ID) {
		/*Person person=em.find(Person.class, ID);
		em.remove(person);				//session.delete(entity);
*/		
		 em.createQuery("DELETE FROM Person p WHERE p.id="+ID).executeUpdate();
	}
	
}