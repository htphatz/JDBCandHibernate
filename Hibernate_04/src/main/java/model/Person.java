package model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private long id;
	
	private String name;
	private Date dateOfBirth;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "spouse_id")
	private Person spouse;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, Date dateOfBirth, Person spouse) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.spouse = spouse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Person getSpouse() {
		return spouse;
	}

	public void setSpouse(Person spouse) {
		this.spouse = spouse;
	}

	@Override
	public String toString() {
		if (this.spouse == null) {
			return "Person [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", spouse= co cai nit]";
		}
		return "Person [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", spouse=" + spouse.name + "]";
	}

}
