package EmpManagementAppService;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import EmpMangementAppModel.Employee;

public class ImportExportData {
    public void Importingdata(Map<Integer, Employee> empMap, ExecutorService exs) {
        System.out.println(Thread.currentThread().getName());//Start Thread
        System.out.println("Import Task Started...");
        try {
            // TimeUnit.SECONDS.sleep(2);
            BufferedReader in = null;
            PrintWriter out = null;

            in = new BufferedReader(new FileReader("C:\\Training\\lowes_javabootcamp-dih-batch2\\temp1\\input.txt"));
            out = new PrintWriter(new FileWriter("C:\\Training\\lowes_javabootcamp-dih-batch2\\temp1\\output.txt"));

            String line = null;

            //Date Fields
            LocalDate date = LocalDate.now();
            LocalDateTime createTime = LocalDateTime.now();
            LocalDateTime modifyTime = LocalDateTime.now();

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
                        sal, date, createTime, modifyTime);
                empMap.put(id, empimp);
            }
            System.out.println("\n" + "Employee Data Imported Successfully.");
            Iterator<Employee> it = empMap.values().iterator();
            while (it.hasNext()) {
                Employee e = it.next();
                System.out.println("Emp ID \t Name \t Age \t Designation   \t Department    \t Country   \t Salary  \t DateofJoining  \t CreatedTime   \t ModifiedTime");
                System.out.printf("%d   \t %s   \t%d  \t%s   \t%s   \t %s     \t %d  \n ", e.getEmpid(), e.getName(),
                        e.getAge(), e.getDesignation(), e.getDepartment(), e.getCountry(), e.getSalary(), e.getDateofjoining(), e.getCreatedTime(), e.getModifiedtime());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Import Task Ended..");
    };
}


































