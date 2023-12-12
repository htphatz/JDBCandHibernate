package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class TestCat2 {
	public static void main(String[] args) {
		// Transient
		Cat cat = new Cat("Meo long xu", new Date(System.currentTimeMillis()), false);
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Thực hiện câu lệnh HQL
				// Them cat vao CSDL
				// Persistent
				session.save(cat);
				transaction.commit();
				
				// Persistent => Detached
				session.refresh(cat);
				
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
