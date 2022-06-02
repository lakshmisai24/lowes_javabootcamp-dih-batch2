package com.empapp.dao;

import com.empapp.service.ExportEmpDataService;
import com.empapp.service.ImportExportData;
import com.empapp.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeDaoServiceImpl implements EmployeeDaoService {

   EmployeeDaoServiceImpl employeeDao;
    List<Employee> employeeList = new ArrayList<>();

    Connection con = null;
    Statement st = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

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

    @Override
    public boolean createemployee(Employee e) {
        // Insertion using Prepared Statement
        try {
            con = getConnection();
            String sql = "INSERT INTO employee(name, age, designation, department, country, salary, doj, createdTime) " +
                    "VALUES (?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getName());
            pstmt.setInt(2, e.getAge());
            pstmt.setString(3, e.getDesignation());
            pstmt.setString(4, e.getDepartment());
            pstmt.setString(5, e.getCountry());
            pstmt.setDouble(6, e.getSalary());
            pstmt.setDate(7, Date.valueOf(e.getDateofjoining()));  // convert LocalDate to Date
            pstmt.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now())); // convert LocalDateTime to Timestamp
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
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
        return false;
    }

    @Override
    public boolean updateemployee(Employee e) {
        // Updation with Prepared Statement
        try {
            con = getConnection();
            String updateQuery = "UPDATE employee SET id = ? , name = ? , age = ? , designation = ? , department = ?" +
                    " , country = ? , salary = ? , doj = ? , modifiedTime = ?  WHERE id = ?";
            pstmt = con.prepareStatement(updateQuery);
            pstmt.setInt(1, e.getEmpid());
            pstmt.setString(2, e.getName());
            pstmt.setInt(3, e.getAge());
            pstmt.setString(4, e.getDesignation());
            pstmt.setString(5, e.getDepartment());
            pstmt.setString(6, e.getCountry());
            pstmt.setDouble(7, e.getSalary());
            pstmt.setDate(8, Date.valueOf(e.getDateofjoining()));  // convert LocalDate to Date
            //pstmt.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now())); // convert LocalDateTime to Timestamp   , no need to set
            pstmt.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.setInt(10, e.getEmpid());

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
        return false;
    }

    @Override
    public boolean deleteemployee(int empId) {
        // Deletion with Prepared Statement
        try {
            con = getConnection();
            String deleteQuery = "DELETE FROM employee WHERE id = ?";
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
            String query = "SELECT id,name,age,designation,department,country,salary,doj,createdTime,modifiedTime FROM employee WHERE id = ? ";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empId);
            rs = pstmt.executeQuery();
            System.out.println("Query executed Successfully: ");
            while (rs.next()) {
                emp = new Employee();
                emp.setEmpid(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartment(rs.getString("department"));
                emp.setCountry(rs.getString("country"));
                emp.setSalary(rs.getInt("salary"));
                emp.setDateofjoining(rs.getDate("doj").toLocalDate());
                emp.setCreatedTime(rs.getTimestamp("createdTime").toLocalDateTime());

                Timestamp modifiedTime = rs.getTimestamp("modifiedTime");
                if (modifiedTime != null) {
                    emp.setModifiedtime(modifiedTime.toLocalDateTime());
                }
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
    public List<Employee> displayemployees() {
        try {
            con = getConnection();
            st = con.createStatement();
            String query = "select * from employee;";
            rs = st.executeQuery(query);
            System.out.println("Query executed Successfully: ");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmpid(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setDesignation(rs.getString("designation"));
                emp.setDepartment(rs.getString("department"));
                emp.setCountry(rs.getString("country"));
                emp.setSalary(rs.getInt("salary"));

                emp.setDateofjoining(rs.getDate("doj").toLocalDate());
                emp.setCreatedTime(rs.getTimestamp("createdTime").toLocalDateTime());

                Timestamp modifiedTime = rs.getTimestamp("modifiedTime");
               if (modifiedTime != null) {
                    emp.setModifiedtime(modifiedTime.toLocalDateTime());
               }
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

    @Override
    public void bulkImport() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ImportExportData imp = new ImportExportData();
        imp.Importingdata(employeeList, executorService);
        return;
    }

    @Override
    public void bulkExport() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExportEmpDataService expd = new ExportEmpDataService();
        employeeList=displayemployees();
        expd.ExportingData(employeeList, executorService);
        executorService.shutdown();
        return;
    }


    public boolean validate(Employee emp, String message, Predicate<Employee> condition) {
        boolean predResult = condition.test(emp);
        if (!predResult) {
            System.out.println(message);
        }
        return predResult;
    }




    public List<Employee> getAll() {  // View all Employees
        employeeList=employeeDao.displayemployees();
        return employeeList;
    }

    @Override
    public long getEmployeeCountAgeGreaterThan(Predicate<Employee> condition) {
        return employeeList.stream().filter(condition).count();

    }

    @Override
    public List<Integer> getEmployeeIdsAgeGreaterThan(int age) {
        return employeeList
                .stream()
                .filter(employee -> employee.getAge() > age)
                .map(p -> p.getEmpid()).collect(Collectors.toList());
    }

    @Override
    public Map<String, Long> getEmployeeCountByDepartment() {
        return employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    @Override
    public Map<String, Long> getEmployeeCountByDepartmentOrdered() {
        return employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.counting()));
    }

    @Override
    public Map<String, Double> getAvgEmployeeAgeByDept() {
         return employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getAge)))
                .entrySet()
                .stream()
                .map(entry -> {
                    entry.setValue(roundDouble(entry.getValue())); // round double value to 2 decimal points
                    return entry;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));  // convert entry to map
    }

    @Override
    public List<String> getDepartmentsHaveEmployeesMoreThan(int criteria) {
         return employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > criteria)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getEmployeeNamesStartsWith(String prefix) {
         return employeeList
                .stream()
                .map(Employee::getName)
                .filter(name -> name.startsWith(prefix))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> getAvgEmployeeServiceByDept() {
         return employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(employees -> {
                    Period period = Period.between(employees.getDateofjoining(), LocalDate.now());
                    return period.getYears();
                })))
                .entrySet()
                .stream()
                .map(entry -> {
                    entry.setValue(roundDouble(entry.getValue())); // round double value to 2 decimal points
                    return entry;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));  // convert entry to map
    }

    private double roundDouble(Double value) {
        BigDecimal val = BigDecimal.valueOf(value);  // convert double value to BigDecimal
        val = val.setScale(2, RoundingMode.HALF_UP);  // Set scale to 2 decimal points and round to nearest big value
        return val.doubleValue(); // convert BigDecimal to double                                        // Ex : 4.789 = 4.79
    }
}



