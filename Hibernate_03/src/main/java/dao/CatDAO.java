package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Cat;
import util.HibernateUtil;

public class CatDAO implements CatDAOInterface<Cat>{

	@Override
	public List<Cat> selectAll() {
		List<Cat> ketQua = new ArrayList<Cat>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Thực hiện câu lệnh HQL
				String HQL = "FROM Cat c";
				Query query = session.createQuery(HQL);
				ketQua = query.getResultList();
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public Cat selectById(Cat cat) {
		List<Cat> ketQua = new ArrayList<Cat>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Thực hiện câu lệnh HQL
				String HQL = "FROM Cat c WHERE c.id =: id";
				Query query = session.createQuery(HQL);
				query.setParameter("id", cat.getId());
				ketQua = query.getResultList();
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (ketQua.size() > 0) {
			return ketQua.get(0);
		} else {
			return null;
		}
	}

	@Override
	public boolean insert(Cat cat) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Thực hiện câu lệnh HQL
				// Chỉ lưu khi chưa tồn tại
				session.save(cat);
				
				// Thêm mới khi chưa tồn tại, nếu tồn tại thì update
				// session.saveOrUpdate(cat);
				
				transaction.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Cat cat) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Thực hiện câu lệnh HQL
				// Chỉ lưu khi chưa tồn tại
				// session.save(cat);
				
				// Thêm mới khi chưa tồn tại, nếu tồn tại thì update
				session.saveOrUpdate(cat);
				
				transaction.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Cat cat) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				// Thực hiện câu lệnh HQL
				session.delete(cat);
				
				transaction.commit();
				session.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
