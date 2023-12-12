package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.ChiTietDonHang;
import model.DonHang;
import util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
			
//				DonHang dh = new DonHang();
//				dh.setTenKhachHang("Huynh Tan Phat");
//				dh.setNgayMua(new Date(123, 1, 30));
//				
//				for (int i = 0; i < 500; i++) {
//					ChiTietDonHang ctdh = new ChiTietDonHang();
//					ctdh.setTenSanPham("Hang " + i);
//					ctdh.setGiaBan(10000);
//					ctdh.setSoLuong(2);
//					ctdh.setThanhTien(2*10000);
//					ctdh.setDonHang(dh);
//					dh.addCTDH(ctdh);
//				}
//				
//				session.save(dh);
				
				long batDau = System.currentTimeMillis();
				DonHang dh = session.load(DonHang.class, 1);
				long ketThuc = System.currentTimeMillis();
				System.out.println(dh.toString());
				List<ChiTietDonHang> ds =  dh.getDanhSachChiTiet();
				for (ChiTietDonHang ctdh : ds) {
					System.out.println(ctdh.toString());
				}
				System.out.println("Thời gian thực hiện câu lệnh là: "+ (ketThuc - batDau));
				
				transaction.commit();
				session.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
