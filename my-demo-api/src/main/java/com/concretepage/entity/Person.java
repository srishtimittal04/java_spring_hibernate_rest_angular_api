package com.concretepage.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "person", uniqueConstraints = { @UniqueConstraint(columnNames = { "DEPT_NO" }) })
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull(message="name should not be empty..........")
	@Size(min=2, message="Name should have atleast 2 characters.........")
	@Pattern(regexp = "^[A-Za-z. ]+$", message="Name should be valid.........")
	private String name;
	
	@Column(name="city", length = 40, nullable = false)
	@Pattern(regexp = "^[A-Za-z0-9. ]*$")
	private String city;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="person_credentials_id")
	PersonCredentials personCredentials;
	
				// course entity has also mapped separately in database
	/*@OneToMany( //fetch=FetchType.LAZY,
			  mappedBy="person",
			  cascade= {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	private List<Course> courses;
	*/
	public Person() {
		
	}
	
	public Person(String name, String city) {
		super();
	//	this.id = id;
		this.name = name;
		this.city = city;
	//	this.personCredentials = personCredentials;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		System.out.println("\n ......inside entity on getName()..... \n");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public PersonCredentials getpersonCredentials() {
		return personCredentials;
	}

	public void setpersonCredentials(PersonCredentials personCredentials) {
		this.personCredentials = personCredentials;
	}

	/*public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
			//adding convenience methods for bi-directional relationship
	public void add(Course cTemp) {
		if(courses== null)
			courses= new ArrayList<>();
		
		// the bi directional relation is done like...
		courses.add(cTemp);	//mapping course to person
		cTemp.setPerson(this);	//mapping Person to Course
		
	}
*/
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	
	
}
