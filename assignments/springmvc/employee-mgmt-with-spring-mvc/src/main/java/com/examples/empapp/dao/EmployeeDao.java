package com.examples.empapp.dao;

import com.examples.empapp.controller.EmployeeController;
import com.examples.empapp.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDao {

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

    public boolean addEmployee(Employee employee) {  // add employee
        // Insertion using Prepared Statement
        try {
            con = getConnection();

            String sql = "INSERT INTO employee" +
                    "(name,age,designation," +
                    "department,country) " +
                    "VALUES (?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getAge());
            pstmt.setString(3, employee.getDesignation());
            pstmt.setString(4, employee.getDepartment());
            pstmt.setString(5, employee.getCountry());
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean update(Employee emp) {  // update employee
        try {
            con = getConnection();
            String updateQuery = "UPDATE employee SET  name = ? , age = ?" +
                    ",designation = ?,department = ? " +
                    ",country = ?  WHERE id = ?";
            pstmt = con.prepareStatement(updateQuery);
            pstmt.setString(6, emp.getId());
            pstmt.setString(1, emp.getName());
            pstmt.setInt(2, emp.getAge());
            pstmt.setString(3, emp.getDesignation());
            pstmt.setString(4, emp.getDepartment());
            pstmt.setString(5, emp.getCountry());
            int updateCount = pstmt.executeUpdate();
            if (updateCount > 0) {
                System.out.println(updateCount + " records updated ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean delete(String empId) {   // delete employee
        // Deletion with Prepared Statement
        try {
            con = getConnection();
            String deleteQuery = "DELETE FROM employee WHERE id = ?";
            pstmt = con.prepareStatement(deleteQuery);
            pstmt.setString(1, empId);
            int deleteCount = pstmt.executeUpdate();
            if (deleteCount > 0) {
                System.out.println(deleteCount + " Employee(s) deleted");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    public List<Employee> getAllEmployees() {   // get all employees
        List<Employee> employeeList = new ArrayList<>();

        try {
            con = getConnection();
            st = con.createStatement();
            String query = "select * from employee";
            rs = st.executeQuery(query);
            System.out.println("Query executed Successfully: " + query);
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getString("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartment(rs.getString("department"));
                emp.setCountry(rs.getString("country"));
                employeeList.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }
                closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }


    public Employee get(String empId) {   // get employee
        Employee emp = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM employee WHERE id = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empId);
            // System.out.println("emp id is : " + empId);
            rs = pstmt.executeQuery();
            System.out.println("Query executed Successfully: " + query);
            while (rs.next()) {
                emp = new Employee();
                emp.setId(rs.getString("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartment(rs.getString("department"));
                emp.setCountry(rs.getString("country"));
            }

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
        return emp;
    }
}

