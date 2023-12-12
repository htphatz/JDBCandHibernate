package model;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class SinhVien extends ConNguoi{
	private double diemTB;
	
	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	public SinhVien(String id, String hoVaTen, Date ngaySinh, double diemTB) {
		super(id, hoVaTen, ngaySinh);
		this.diemTB = diemTB;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}
}
