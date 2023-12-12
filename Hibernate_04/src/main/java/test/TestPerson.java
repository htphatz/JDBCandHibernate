package test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Person;
import util.HibernateUtil;

public class TestPerson {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Tạo person1
				// Person person1 = new Person("Nguyen Van A", new Date(System.currentTimeMillis()), null);
				// session.save(person1);
				
				// Person person1 = session.find(Person.class, 1L);
				// Person person2 = new Person("Nguyen Thi C", new Date(System.currentTimeMillis()), person1);
				// session.save(person2);
				
				Person person1 = session.find(Person.class, 1L);
				Person person2 = session.find(Person.class, 2L);
				person1.setSpouse(person2);
				
				session.saveOrUpdate(person1);
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
