/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import las.db_utilities.DBConnection;
import las.db_utilities.DBHandler;
import las.models.User;

/**
 *
 * @author Gimhani
 */
public class UserController {
    public static int addNewUser(User user) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Insert into User Values('" + user.getName()+ "','" + user.getPassword() + "'," + user.getPower()+ ")";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int updateUser(User user) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Update User set password=(select password('" + user.getPassword() + "')),power=" + user.getPower() + " where user='" + user.getName()+ "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static int updatePassword(User user) throws SQLException, ClassNotFoundException {
        DBConnection dbconn = DBConnection.getDBConnection();
        Connection conn = dbconn.getConnection();
        String sql = "Update User set password=(select password('" + user.getPassword() + "')) where name='" + user.getName()+ "'";
        int res = DBHandler.setData(conn, sql);
        return res;
    }

    public static ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from User ";
        ResultSet rst = DBHandler.getData(conn, sql);
        ArrayList<User> users = new ArrayList<>();
        while (rst.next()) {
            User user = new User(rst.getString("name"), rst.getString("password"), rst.getInt("power"));
            users.add(user);
        }
        return users;
    }

    public static User searchUser(String name) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select * from User where name='" + name + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        User user = null;
        while (rst.next()) {
            user = new User(rst.getString("name"), rst.getString("password"), rst.getInt("power"));
        }
        return user;
    }

    public static boolean matchPassword(String name, String entertext) throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        String sql = "Select password,(select password('" + entertext + "')) as entered from User where name='" + name + "' ";
        ResultSet rst = DBHandler.getData(conn, sql);
        boolean matched = false;

        while (rst.next()) {
            System.out.println("bool");
            if (rst.getString("password").equals(rst.getString("entered"))) {
                matched = true;
                System.out.println("t");
            } else {
                matched = false;
                System.out.println("f");
            }
        }
        return matched;
    }
}
