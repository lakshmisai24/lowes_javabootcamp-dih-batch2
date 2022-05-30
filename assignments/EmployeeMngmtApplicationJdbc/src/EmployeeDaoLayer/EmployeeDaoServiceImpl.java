package EmployeeDaoLayer;

import EmployeeDaoLayer.EmployeeDaoService;
import EmployeeModel.Employee;
import EmployeeService.EmployeeService;
import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoServiceImpl implements EmployeeDaoService {

    MysqlDataSource dataSource = null;
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public EmployeeDaoServiceImpl() {
        dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("jdbctraining");
        dataSource.setUser("training");
        dataSource.setPassword("training");

        try {
            conn = dataSource.getConnection();
            System.out.println("Connection created successfully " + conn);
        } catch (SQLException e) {
            // e.printStackTrace();
        }
    }


    @Override
    public boolean createEmployee(Employee e) {
        boolean status = false;
        try {
            stmt = conn.createStatement();

            String query = "INSERT INTO employee (name,age,designation,department,country,salary,doj) VALUES(\""
                    + e.getName() + "\"," + e.getAge() + ",\"" + e.getDesignation() + "\",\""
                    + e.getDepartment() + "\",\"" + e.getCountry() + "\",\""+e.getSalary() +"\",\""+ e.getDateofjoining()
                     + "\")";
            status = stmt.execute(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean updateEmployee(Employee e) {
        boolean status = false;
        try {
            stmt = conn.createStatement();

            String query = "UPDATE employee SET name = \"" + e.getName() + "\", age = " + e.getAge()
                    + " ,designation = \"" + e.getDesignation() + "\" ,department = \"" + e.getDepartment()
                    + "\",country=\"" + e.getCountry() +"\" ,salary = \"" +e.getSalary()+"\"," +"\" ,doj = \"" +e.getDateofjoining()+
                    "\" ,createdTime = \"" +LocalDateTime.now()+ "modifiedTime=\"" + LocalDateTime.now() + "\" WHERE id = "
                    + e.getEmpid();
            status = stmt.execute(query);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        boolean status = false;
        try {
            stmt = conn.createStatement();

            String query = "DELETE FROM employee WHERE id = " + empId;
            status = stmt.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Employee get(int empId) {

        Employee emp = null;
        String query = "SELECT * FROM employee WHERE id = " + empId;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String country = rs.getString("country");
                LocalDate doj = rs.getDate("dateofjoining").toLocalDate();
                int sal=rs.getInt("salary");
                LocalDate doj1 = rs.getDate("doj").toLocalDate();
                //LocalDateTime createdtime = rs.getDate("createdTime").getTime();
                //LocalDateTime modifiedtime = rs.getDate("modifiedTime").getTime();
                emp=new Employee(id, name, age, designation, department, country,sal,doj1);

            }

        } catch (SQLException e) {
            //e.printStackTrace();
            System.out.println("This employee does not exist!");
        }

        return emp;
    }

    @Override
    public List<Employee> displayEmployees() {
        List<Employee> emplist = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String designation = rs.getString("designation");
                String department = rs.getString("department");
                String country = rs.getString("country");
                int sal=rs.getInt("salary");
                LocalDate doj = rs.getDate("doj").toLocalDate();
                //LocalDateTime createdtime = rs.getDate("createdTime").getTime();
                //LocalDateTime modifiedtime = rs.getDate("modifiedTime").getTime();
                emplist.add(new Employee(id, name, age, designation, department, country,sal,doj));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emplist;
    }
}
