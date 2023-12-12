package test;


import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
//				Author author_1 = new Author("001", "Nguyen Nhat Anh", new Date(System.currentTimeMillis()));
//				Book book_1 = new Book("B01", "Cho toi xin mot ve ve tuoi tho", 59000, author_1);
//				Book book_2 = new Book("B02", "Toi thay hoa vang tren co xanh", 69000, author_1);
//				Book book_3 = new Book("B03", "Toi la Beto", 29000, author_1);
//				
//				session.save(author_1);
//				session.save(book_1);
//				session.save(book_2);
//				session.save(book_3);
				
				Author author_2 = new Author("002", "Le Nhat Tung", new Date(System.currentTimeMillis()));
				Book book_4 = new Book("B04", "Lap trinh Java", 59000, author_2);
				Book book_5 = new Book("B05", "Lap trinh C++", 69000, author_2);
				Book book_6 = new Book("B06", "Lap trinh Hibernate", 29000, author_2);
				
				session.save(author_2);
				session.save(book_4);
				session.save(book_5);
				session.save(book_6);
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
