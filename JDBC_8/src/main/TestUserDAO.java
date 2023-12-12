
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.UserDAO;
import model.User;

/**
 *
 * @author HP
 */
public class TestUserDAO {
    public static void main(String[] args) {
        try {
            // User user1 = new User("vankhoa_1", "123456", "Nguyen Van Khoa");
            //  UserDAO.getInstance().insert(user1);
            
            // User user_normal = new User("vankhoa_1", "", "");
            // User selectedNormalUser = UserDAO.getInstance().selectByName(user_normal);
            // System.out.println(selectedNormalUser.toString());
            
            User user_SQLInjection = new User("x\' or 1=1; -- ", "", "");
            User selectedInjectedlUser = UserDAO.getInstance().selectByName(user_SQLInjection);
            System.out.println(selectedInjectedlUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
