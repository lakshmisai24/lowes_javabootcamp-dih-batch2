package com.empapp.service;

import com.empapp.model.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ImportExportData {
    public void Importingdata(Map<Integer, Employee> empMap, ExecutorService exs) {
        System.out.println(Thread.currentThread().getName());//Start Thread
        System.out.println("Import Task Started...");
        try {
            // TimeUnit.SECONDS.sleep(2);
            BufferedReader in = null;
            PrintWriter out = null;

            in = new BufferedReader(new FileReader("C:\\Training\\lowes_javabootcamp-dih-batch2\\temp1\\input.txt"));

            String line = null;
            while ((line = in.readLine()) != null) {
                String[] empdata = line.split(",");
                int id = empMap.size() + 1;
                String name = empdata[0];
                int age = Integer.parseInt(empdata[1]);
                String Designation = empdata[2];
                String department = empdata[3];
                String Country = empdata[4];
                int sal = Integer.parseInt(empdata[5]);
                Employee empimp = new Employee(id, name, age, Designation, department, Country,
                        sal);
                empMap.put(id, empimp);
            }
            System.out.println("\n" + "Employee Data Imported Successfully.");
            Iterator<Employee> it = empMap.values().iterator();
            while (it.hasNext()) {
                Employee e = it.next();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Import Task Ended..");
    };
}


































