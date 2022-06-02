package empapp.service;

import empapp.model.Employee;

import java.io.*;
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
            for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {
                bf.write(entry.getValue().getName()+","+entry.getValue().getAge()+","+
                        entry.getValue().getDesignation()+","+entry.getValue().getDepartment()+","+entry.getValue().getCountry()+
                        ","+entry.getValue().getSalary());
                bf.newLine();
            }
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

