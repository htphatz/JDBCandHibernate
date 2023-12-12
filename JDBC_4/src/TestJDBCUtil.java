
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class TestJDBCUtil {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        // Bước 1: Tạo kết nối
        Connection connection = JDBCUtil.openConnection();
        
        // Bước 2: Tạo đối tượng statement
        Statement statement = connection.createStatement();
        
        // Bước 3: Thưc thi câu lệnh SQL
        String sql = "INSERT INTO dbo.Persons (person_id, last_name, first_name, gender, dob, income)\n" +
                     "VALUES (10, 'Nguyen', 'Huu Canh', 'M', '1999-12-01', 0),\n" +
"                    (11, 'Tran', 'Xuan Dieu', 'G', '2007-02-09', 4000000);";
        int check = statement.executeUpdate(sql);
        
        // Bước 4: Xử lý kết quả trả về
        System.out.println("Số dòng thay đổi: " + check);
        if (check > 0){
            System.out.println("Thêm dữ liệu thành công");
        }
        else {
            System.out.println("Thêm dữ liệu thất bại");
        }
        
        // Bước 5: Ngắt kết nối
        JDBCUtil.closeConnection(connection);
    }
}
