package EmployeeService;

import EmployeeModel.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ExportEmpDataService {
    public void ExportingData(Map<Integer, Employee> empMap, ExecutorService exs)  {
        System.out.println(Thread.currentThread().getName());//Start Thread
        System.out.println("Export Task Started...");
        BufferedWriter bf = null;
        try {
            File file = new File("C:\\Training\\lowes_javabootcamp-dih-batch2\\temp1\\output.txt");

            bf = null;

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
bf.write("Emp ID    Name     Age     Designation      Department     Country     Salary     DateofJoining     CreatedTime    ModifiedTime");
            // iterate map entries
            for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey()  + "  "+entry.getValue().getName()+"  "+entry.getValue().getAge()+"  "+
                        entry.getValue().getDesignation()+"  "+entry.getValue().getDepartment()+"  "+entry.getValue().getCountry()+
                        "  "+entry.getValue().getSalary()+"  "+entry.getValue().getDateofjoining()+"  "
                        +entry.getValue().getCreatedTime()+"  "+
                        entry.getValue().getModifiedtime()+'\n');
                // new line
                bf.newLine();
            }
            bf.flush();
            System.out.println("Employee Data exported successfully.");

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

