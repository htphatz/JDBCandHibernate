package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.GiaoVien;
import model.SinhVien;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
			
				GiaoVien gv = new GiaoVien("GV", "Giao vien ", new Date(System.currentTimeMillis()), "Hibernate");
				SinhVien sv = new SinhVien("SV", "Sinh vien ", new Date(System.currentTimeMillis()), 9.8);
				session.save(gv);
				session.save(sv);
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
