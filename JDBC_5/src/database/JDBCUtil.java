package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author HP
 */
public class JDBCUtil {
    public static Connection openConnection() throws ClassNotFoundException{
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Các thông số
            String url = "jdbc:sqlserver://HP\\SQLEXPRESS:1433;databaseName=QUANLYSACH;encrypt=true;trustServerCertificate=true";
            String userName  = "sa";
            String password = "1234567890";
            
            // Tạo kết nối
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
    
    public static void closeConnection(Connection connection) throws InterruptedException {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
