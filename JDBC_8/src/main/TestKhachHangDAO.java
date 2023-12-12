/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.KhachHangDAO;
import java.util.ArrayList;
import model.KhachHang;
/**
 *
 * @author HP
 */
public class TestKhachHangDAO {
    public static void main(String[] args) {
        try {
            /* Test selectAll - Select toàn bộ khách hàng trong bảng */
            ArrayList<KhachHang> listKhachHang = KhachHangDAO.getInstance().selectAll();
            for (KhachHang khachHang: listKhachHang){
                System.out.println(khachHang.toString());
            }
        } catch (Exception e) {
        }
    }
}
