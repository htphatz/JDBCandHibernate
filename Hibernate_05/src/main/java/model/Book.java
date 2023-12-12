package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private String bookID;
	private String title;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "authorID")
	private Author author;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String bookID, String title, double price, Author author) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.price = price;
		this.author = author;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookID=" + bookID + ", title=" + title + ", price=" + price + "]";
	}
	
}
