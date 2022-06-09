package service;


import model.Employee;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Component
public class ExportEmpDataService {

    public void ExportingData(List<Employee> employees, ExecutorService exs)  {
        System.out.println(Thread.currentThread().getName());//Start Thread
        System.out.println("Export Task Started...");
        BufferedWriter bf = null;
        try {
            File file = new File("C:\\Training\\lowes_javabootcamp-dih-batch2\\temp1\\output.txt");

            bf = null;

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
           for (Employee emp:employees) {

                bf.write( emp.getEmpid() + "," + emp.getName() + "," + emp.getAge() + "," +
                        emp.getDepartment() + "," + emp.getDesignation() + "," + emp.getCountry() + "," + emp.getSalary() + "," +
                        emp.getDateofjoining() + "," + emp.getCreatedTime() + "," + emp.getModifiedtime());
               bf.newLine();
            }
            System.out.println("Employee Data exported successfully.");
bf.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Export Task Ended..");

    }
}

