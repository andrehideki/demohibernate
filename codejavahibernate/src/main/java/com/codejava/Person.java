package com.codejava;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private long id;
	private String firstName;
	private String lastName;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(	joinColumns = {@JoinColumn(name = "person_id")},
				inverseJoinColumns = {@JoinColumn(name = "address_id")})
	private Set<Address> addresses = new HashSet<Address>();
	
	public Person() {}
	public Person(long id, String firstName, String lastName, Set<Address> addresses) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresses = addresses;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
}
