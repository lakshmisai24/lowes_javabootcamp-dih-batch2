package service;


import dao.EmployeeDaoServiceImpl;
import model.Employee;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.ExecutorService;


@Component
public class ImportExportData {
    EmployeeDaoServiceImpl employeeDao=new EmployeeDaoServiceImpl();
    public void Importingdata(List<Employee> employeeList, ExecutorService exs) {
        System.out.println(Thread.currentThread().getName());//Start Thread
        System.out.println("Import Task Started...");
        try {
            // TimeUnit.SECONDS.sleep(2);
            BufferedReader in = null;
            PrintWriter out = null;

            in = new BufferedReader
                    (new FileReader("C:\\Training\\lowes_javabootcamp-dih-batch2\\temp1\\input.txt"));


            String line = null;

            //Date Fields
            LocalDate date = LocalDate.now();
            LocalDateTime createTime = LocalDateTime.now();
            LocalDateTime modifyTime = LocalDateTime.now();

            while ((line = in.readLine()) != null) {
                Employee emp = new Employee();
                    String[] tokens = line.split(",");

                emp.setName(tokens[0]);
                emp.setAge(Integer.parseInt(tokens[1]));
                emp.setDesignation(tokens[2]);
                emp.setDepartment(tokens[3]);
                emp.setCountry(tokens[4]);
                emp.setSalary((int) Double.parseDouble(tokens[5]));
                emp.setDateofjoining(LocalDate.parse(tokens[6], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                emp.setCreatedTime(LocalDateTime.parse(tokens[7]));
                employeeDao.createemployee(emp);
            }

            System.out.println("\n" + "Employee Data Imported Successfully.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Import Task Ended..");
    };
}


































