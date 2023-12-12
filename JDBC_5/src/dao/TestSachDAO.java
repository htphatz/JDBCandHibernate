/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import model.Sach;
/**
 *
 * @author HP
 */
public class TestSachDAO {
    public static void main(String[] args) {
        try {
            /* Test insert - Thêm vào sách 1 */
            // Sach sach1 = new Sach("Lập trình X", 200000, 2003);
            // SachDAO.getInstance().insert(sach1);
            
            /* Test update - Update sách có tên "Lap trinh Java" trong CDSL có giá mới và năm xuất bản mới */
            // Sach sach2 = new Sach("Lap trinh Java", 250000, 2012);
            // SachDAO.getInstance().update(sach2);
            
            /* Test delete - Delete sách có tên "Lap trinh Java" */
            // Sach sach3 = new Sach("Lap trinh Java");
            // SachDAO.getInstance().delete(sach3);
            
            /* Test selectAll - SelectAll sách có trong CSDL */
            // ArrayList<Sach> listSach = SachDAO.getInstance().selectAll();
            // for(Sach sach: listSach){
            //    System.out.println(sach.toString());
            // }
            
            /* Test selectByName - Select sách có tên "Lap trinh Python" */
            // Sach selectedSach = SachDAO.getInstance().selectByName("Lap trinh Python");
            // System.out.println(selectedSach.toString());
            
            /* Test selectByCondition - Select những quyển sách có giá dưới 45000*/
             ArrayList<Sach> listSach = SachDAO.getInstance().selectByCondition("GiaBan < 45000");
             for(Sach sach: listSach){
                System.out.println(sach.toString());
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
