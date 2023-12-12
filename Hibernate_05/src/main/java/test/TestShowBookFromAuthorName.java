package test;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Author;
import model.Book;
import util.HibernateUtil;

public class TestShowBookFromAuthorName {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				String HQL = "SELECT b.bookID, b.title, b.price, b.author.name FROM Book b WHERE b.author.name =: name";
				Query query = session.createQuery(HQL);
				query.setParameter("name", "Le Nhat Tung");
				List<Object[]> list = query.getResultList();
				for(Object[] rs: list) {
					String bookID = rs[0] + "";
					String title = rs[1] + "";
					String price = rs[2] + "";
					String authorName = rs[3] + "";
					
					System.out.println("Author: " + authorName + " - " + "BookID: " + bookID + " - "
							+ "Price: " + price + " - " + "Title: " + title);
				}
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
