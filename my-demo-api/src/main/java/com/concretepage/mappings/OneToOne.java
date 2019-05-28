/*package com.concretepage.mappings;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.concretepage.entity.Person;
import com.concretepage.entity.PersonCredentials;

@Repository
@Transactional
public class OneToOne {
	@PersistenceContext
	static
	EntityManager em;
	
	public static void main(String args[]) {
		PersonCredentials pc = new PersonCredentials("abcd");
		Person p = new Person("ritu","kotdwar");
		p.setpersonCredentials(pc);
		System.out.println("\n\nsaving person and personcredentials by OneToOne "+p+"  "+pc+"\n\n");
		em.persist(p);
	}

}
*/