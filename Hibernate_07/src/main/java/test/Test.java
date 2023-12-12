package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.CuocHop;
import model.NhanVien;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
			
				NhanVien nv1 = new NhanVien("001", "Huynh Tan Phat", new Date(2003,  12, 1));
				// session.save(nv1);
				
				CuocHop ch1 = new CuocHop();
				ch1.setTenCuocHop("Hop A");
				ch1.setThoiGian(new Date(2012, 12, 1));
				ch1.setDiaDiem("Phong dao tao");
				ch1.addNhanVien(nv1);
				session.save(ch1);
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
