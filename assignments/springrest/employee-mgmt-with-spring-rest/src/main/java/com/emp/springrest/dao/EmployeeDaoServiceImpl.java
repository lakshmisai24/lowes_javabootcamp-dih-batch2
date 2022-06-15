package com.emp.springrest.dao;


import com.emp.springrest.model.Employee;

import com.emp.springrest.service.EmployeeDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class EmployeeDaoServiceImpl implements EmployeeDaoService {
    Logger logger = LoggerFactory.getLogger(EmployeeDaoServiceImpl.class);


EmployeeDaoServiceImpl empServImpl;
    @Autowired
    DataSource dataSource;

    List<Employee> employeeList = new ArrayList<>();

    Connection con = null;
    Statement st = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        con = dataSource.getConnection();
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

    @Override
    public Employee createEmployee(Employee e) {
        try {
            con = getConnection();
            String sql = "INSERT INTO employee(name, age, designation, department, country, salary) " +
                    "VALUES (?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getName());
            pstmt.setInt(2, e.getAge());
            pstmt.setString(3, e.getDesignation());
            pstmt.setString(4, e.getDepartment());
            pstmt.setString(5, e.getCountry());
            pstmt.setDouble(6, e.getSalary());
            int rowsInserted = pstmt.executeUpdate();
            logger.info("i created employee");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }finally {
            try {
                pstmt.close();
                closeConnection(con);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return e;
    }
    @Override
    public Employee updateEmployee(int empId,Employee e) {
        // Updation with Prepared Statement
        try {
            con = getConnection();
            String updateQuery = "UPDATE employee  set name = ? , age = ? , designation = ? , department = ?" +
                    " , country = ? , salary = ?  WHERE empid = ?";
            pstmt = con.prepareStatement(updateQuery);

            pstmt.setString(1, e.getName());
            pstmt.setInt(2,e.getAge());
            pstmt.setString(3, e.getDesignation());
            pstmt.setString(4, e.getDepartment());
            pstmt.setString(5, e.getCountry());
            pstmt.setDouble(6, e.getSalary());
            pstmt.setInt(7,empId);
            int updateCount = pstmt.executeUpdate();
            if (updateCount > 0) {
                System.out.println(updateCount + " records updated ");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                pstmt.close();
                closeConnection(con);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return e;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        // Deletion with Prepared Statement
        try {
            con = getConnection();
            String deleteQuery = "DELETE FROM employee WHERE empid = ?";
            pstmt = con.prepareStatement(deleteQuery);
            pstmt.setInt(1, empId);
            int deleteCount = pstmt.executeUpdate();
            if (deleteCount > 0) {
                System.out.println(deleteCount + " Employee(s) deleted");
            }

        } catch (SQLException | ClassNotFoundException e) {
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

    @Override
    public Employee get(int empId) {

        Employee emp = new Employee();
        try {
            con = getConnection();
            String query = "SELECT empid,name,age,designation,department,country,salary FROM employee WHERE empid = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empId);
            rs = pstmt.executeQuery();
            System.out.println("Query executed Successfully: ");
            while (rs.next()) {
                emp = new Employee();
                emp.setEmpid(rs.getInt("empid"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartment(rs.getString("department"));
                emp.setCountry(rs.getString("country"));
                emp.setSalary(rs.getInt("salary"));
            }


        } catch (SQLException | ClassNotFoundException e) {
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

    @Override
    public List<Employee> displayEmployees() {
        try {
            con = getConnection();
            st = con.createStatement();
            String query = "select * from employee;";
            rs = st.executeQuery(query);
            System.out.println("Query executed Successfully: ");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpid(rs.getInt("empid"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartment(rs.getString("department"));
                emp.setCountry(rs.getString("country"));
                emp.setSalary(rs.getInt("salary"));
                employeeList.add(emp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                closeConnection(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }



    public List<Employee> getAll() {  // View all Employees
        employeeList = empServImpl.displayEmployees();
        return employeeList;
    }

}



