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
import model.User;
import java.sql.PreparedStatement;
/**
 *
 * @author HP
 */
public class UserDAO implements DAOInterface<User>{

    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(User user) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            String sql = "INSERT INTO dbo.Users (UserName, Password, HoVaTen)\n" +
                         "VALUES (?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassWord());
            pst.setString(3, user.getHoVaTen());
        
            // Bước 3: Thưc thi câu lệnh SQL
            ketQua = pst.executeUpdate();
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            System.out.println("Đã có " + ketQua + " dòng bị thay đổi");
        
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int update(User user) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            String sql = "UPDATE dbo.Users\n " +
                         "SET UserName = ?, "+  
                         "Password = ?, " + 
                         "HoVaTen = ? "+
                         "WHERE UserName = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUserName());
            pst.setString(2, user.getPassWord());
            pst.setString(3, user.getHoVaTen());
            pst.setString(4, user.getUserName());
        
            // Bước 3: Thưc thi câu lệnh SQL
            ketQua = pst.executeUpdate();
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            System.out.println("Đã có " + ketQua + " dòng bị thay đổi");
        
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int delete(User user) {
        int ketQua = 0;
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            String sql = "DELETE FROM dbo.Users\n" +
                         "WHERE UserName = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUserName());
        
            // Bước 3: Thưc thi câu lệnh SQL
            ketQua = pst.executeUpdate();
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            System.out.println("Đã có " + ketQua + " dòng bị thay đổi");
        
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return ketQua;
    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            String sql = "SELECT * FROM dbo.Users";
            PreparedStatement pst = connection.prepareStatement(sql);
        
            // Bước 3: Thưc thi câu lệnh SQL
            ResultSet rs = pst.executeQuery();
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            while(rs.next()){
                String userName = rs.getString("UserName");
                String passWord = rs.getString("Password");
                String hoVaTen = rs.getString("HoVaTen");
                User user = new User(userName, passWord, hoVaTen);
                ketQua.add(user);
            }
            
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public User selectByName(User user) {
        User ketQua = null;
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            String sql = "SELECT * FROM dbo.Users\n" +
                         "WHERE UserName = ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, user.getUserName());
        
            // Bước 3: Thưc thi câu lệnh SQL 
            ResultSet rs = pst.executeQuery();
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            while(rs.next()){
                String userName = rs.getString("UserName");
                String passWord = rs.getString("Password");
                String hoVaTen = rs.getString("HoVaTen");
                ketQua = new User(userName, passWord, hoVaTen);
            }
            
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
        }

    @Override
    public ArrayList<User> selectByCondition(String condition) {
       ArrayList<User> ketQua = new ArrayList<User>();
        try {
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.openConnection();
        
            // Bước 2: Tạo đối tượng statement
            Statement statement = connection.createStatement();
        
            // Bước 3: Thưc thi câu lệnh SQL
            String sql = "SELECT * FROM dbo.Users WHERE " + condition;
            ResultSet rs = statement.executeQuery(sql);
        
            // Bước 4: Xử lý kết quả trả về
            System.out.println("Bạn đã thực thi câu lệnh:");
            System.out.println(sql);
            while(rs.next()){
                String userName = rs.getString("UserName");
                String passWord = rs.getString("Password");
                String hoVaTen = rs.getString("HoVaTen");
                User user = new User(userName, passWord, hoVaTen);
                ketQua.add(user);
            }
            
            // Bước 5: Ngắt kết nối
            JDBCUtil.closeConnection(connection); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
        }
    }



