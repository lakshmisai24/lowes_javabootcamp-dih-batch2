package com.examples.empapp.dao;


import com.examples.empapp.controller.EmployeeController;
import com.examples.empapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserDao {

    Connection con = null;
    Statement st = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/jdbctraining";  //URL  for mysql
        String root = "training";
        String password = "training";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, root, password);
        return con;
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public boolean add(User user) {
        try {
            con = getConnection();
            String sql = "insert into user(name, password, email) " +
                    "values (?,?,?)";
            String name = user.getName();
            logger.info(name, user);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                closeConnection(con);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }


    public boolean validateUser(User user) {
        try {
            con = con = getConnection();
            String query = "select id from user where name = ? and  password = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
