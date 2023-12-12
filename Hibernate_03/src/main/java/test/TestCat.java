package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat {
	public static void main(String[] args) {
		Cat cat_id3 = new Cat();
		cat_id3.setId(3);
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Thực hiện câu lệnh HQL
				// Lay Cat co id = 3  bang ham get() trong session
				// Persistent
				cat_id3 = session.get(Cat.class, cat_id3.getId());
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cat_id3.toString());
	}
}	
