package test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Customer;
import model.MyOrder;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
//				Customer customer1 = new Customer("C01", "Le Nhat Tung", "titv@gmail.com");
//				
//				MyOrder od1 = new MyOrder("OD01", "TPHCM", customer1);
//				MyOrder od2 = new MyOrder("OD02", "TPHCM", customer1);
//				MyOrder od3 = new MyOrder("OD03", "TPHCM", customer1);
//				MyOrder od4 = new MyOrder("OD04", "TPHCM", customer1);
//				
//				List<MyOrder> list = new ArrayList<MyOrder>();
//				list.add(od1);
//				list.add(od2);
//				list.add(od3);
//				list.add(od4);
//				
//				customer1.setOrders(list);
//				
//				session.saveOrUpdate(customer1);
//				session.saveOrUpdate(od1);
//				session.saveOrUpdate(od2);
//				session.saveOrUpdate(od3);
//				session.saveOrUpdate(od4);
				
//				Customer customer2 = new Customer("C02", "Huynh Tan Phat", "huynhphatsn@gmail.com");
//				session.saveOrUpdate(customer2);
				
				String HQL = "FROM Customer c WHERE size(c.orders) > 0";
				Query query = session.createQuery(HQL);
				List<Customer> results = query.getResultList();
				for (Customer result : results) {
					System.out.println(result);
				}
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
