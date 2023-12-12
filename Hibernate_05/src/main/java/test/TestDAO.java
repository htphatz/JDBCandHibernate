package test;

import java.sql.Date;

import dao.AuthorDAO;
import dao.BookDAO;
import model.Author;
import model.Book;

public class TestDAO {
	public static void main(String[] args) {
		AuthorDAO authorDAO = new AuthorDAO();
		BookDAO bookDAO = new BookDAO();
		
		Author author_3 = new Author("003", "Huynh Tan Phat", new Date(System.currentTimeMillis()));
		Author author_4 = new Author("004", "Nguyen Van Khoa", new Date(System.currentTimeMillis()));
		// authorDAO.insert(author_3);
		// authorDAO.insert(author_4);
		
		Book book_7 = new Book("B07", "Sach A", 11111, author_3);
		Book book_8 = new Book("B08", "Sach B", 22222, author_3);
		Book book_9 = new Book("B09", "Sach C", 33333, author_3);
		Book book_10 = new Book("B10", "Sach A", 11111, author_4);
		Book book_11 = new Book("B11", "Sach B", 22222, author_4);
		Book book_12 = new Book("B12", "Sach C", 33333, author_4);
		bookDAO.insert(book_7);
		bookDAO.insert(book_8);
		bookDAO.insert(book_9);
		bookDAO.insert(book_10);
		bookDAO.insert(book_11);
		bookDAO.insert(book_12);
	}
}
