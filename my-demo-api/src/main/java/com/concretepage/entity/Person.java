package com.concretepage.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
//@Table(name = "DEPARTMENT", uniqueConstraints = { @UniqueConstraint(columnNames = { "DEPT_NO" }) })
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
	
	public Person(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
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
	
	
}
