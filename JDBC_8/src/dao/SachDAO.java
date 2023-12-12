/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.util.ArrayList;
import model.Sach;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class SachDAO implements DAOInterface<Sach>{

    public static SachDAO getInstance() {
        return new SachDAO();
    }

    @Override
    public int insert(Sach sach) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            Statement statement = connection.createStatement();
        
            // Bước 3: Thưc thi câu lệnh SQL
            String sql = "INSERT INTO dbo.Sach (TenSach, GiaBan, NamXuatBan)\n" +
                         "VALUES ('" + sach.getTenSach()+"', '" + sach.getGiaBan()+"', '" + sach.getNamXuatBan()+"')\n";
            ketQua = statement.executeUpdate(sql);
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            System.out.println("Đã có " + ketQua + " dòng bị thay đổi");
        
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int update(Sach sach) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            Statement statement = connection.createStatement();
        
            // Bước 3: Thưc thi câu lệnh SQL
            String sql = "UPDATE dbo.Sach\n" +
                         "SET " + "TenSach = '" + sach.getTenSach() +"', "+
                                  "GiaBan = '" + sach.getGiaBan() +"', "+
                                  "NamXuatBan = '" + sach.getNamXuatBan() +"' "+
                         "WHERE " + "TenSach = '" + sach.getTenSach() +"'";
            ketQua = statement.executeUpdate(sql);
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            System.out.println("Đã có " + ketQua + " dòng bị thay đổi");
        
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int delete(Sach sach) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            Statement statement = connection.createStatement();
        
            // Bước 3: Thưc thi câu lệnh SQL
            String sql = "DELETE FROM dbo.Sach\n" +
                         "WHERE " + "TenSach = '" + sach.getTenSach() +"'";
            ketQua = statement.executeUpdate(sql);
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            System.out.println("Đã có " + ketQua + " dòng bị thay đổi");
        
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            Statement statement = connection.createStatement();
        
            // Bước 3: Thưc thi câu lệnh SQL
            String sql = "SELECT * FROM dbo.Sach";
            ResultSet rs = statement.executeQuery(sql);
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            while(rs.next()){
                int id = rs.getInt("ID");
                String tenSach = rs.getString("TenSach");
                double giaBan = rs.getDouble("GiaBan");
                int namXuatBan = rs.getInt("NamXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                ketQua.add(sach);
            }
            
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public Sach selectByName(Sach sach) {
        Sach ketQua = new Sach();
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            Statement statement = connection.createStatement();
        
            // Bước 3: Thưc thi câu lệnh SQL
            String sql = "SELECT * FROM dbo.Sach\n" +
                         "WHERE " + "TenSach = '" + sach.getTenSach() +"'";
            ResultSet rs = statement.executeQuery(sql);
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            while(rs.next()){
                int id = rs.getInt("ID");
                String tenSach = rs.getString("TenSach");
                double giaBan = rs.getDouble("GiaBan");
                int namXuatBan = rs.getInt("NamXuatBan");
                ketQua.setId(id);
                ketQua.setTenSach(tenSach);
                ketQua.setGiaBan(giaBan);
                ketQua.setNamXuatBan(namXuatBan);
            }
            
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
        }

    @Override
    public ArrayList<Sach> selectByCondition(String condition) {
       ArrayList<Sach> ketQua = new ArrayList<Sach>();
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            Statement statement = connection.createStatement();
        
            // Bước 3: Thưc thi câu lệnh SQL
            String sql = "SELECT * FROM dbo.Sach WHERE " + condition;
            ResultSet rs = statement.executeQuery(sql);
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            while(rs.next()){
                int id = rs.getInt("ID");
                String tenSach = rs.getString("TenSach");
                double giaBan = rs.getDouble("GiaBan");
                int namXuatBan = rs.getInt("NamXuatBan");
                Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
                ketQua.add(sach);
            }
            
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SachDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
        }
    }



