
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class ConnectDatabase {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            // Tạo kết nối
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://HP\\SQLEXPRESS:1433;databaseName=NORTHWND;encrypt=true;trustServerCertificate=true";
            String userName  = "sa";
            String password = "1234567890";
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Kết nối thành công");
            
            String sql =  "SELECT TOP 20 ProductID, ProductName, UnitPrice FROM dbo.Products";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
           
            // Text DatabaseMetaData
            // DatabaseMetaData dbmd = connection.getMetaData();
            // System.out.println("Driver Name: " + dbmd.getDriverName());  
            // System.out.println("Driver Version: " + dbmd.getDriverVersion());  
            // System.out.println("UserName: " + dbmd.getUserName());  
            // System.out.println("Database Product Name: " + dbmd.getDatabaseProductName()); 
            // System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion()); 
            
            while(rs.next()){
                System.out.println(rs.getString("ProductId") + " - " + rs.getString("ProductName") + " - " + rs.getDouble("UnitPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
