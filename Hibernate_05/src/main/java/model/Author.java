package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
	@Id
	private String authorID;
	private String name;
	private Date dateOfBirth;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(String authorID, String name, Date dateOfBirth) {
		super();
		this.authorID = authorID;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
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

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
