import empapp.service.EmployeeServiceImplem;
import empapp.model.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EmployeeMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        int id, sal, age;
        String text = "";
        Scanner sc = new Scanner(System.in);
        String ename, designation, department, country;
        EmployeeServiceImplem eser = new EmployeeServiceImplem();
        do {
            System.out.println("--------------------Welcome To Employee Management App-----------------------" + '\n' +
                    "1.Add Employee" + '\n' + "2.View Employee" + '\n' + "3.Update Employee" + '\n' +
                    "4.Delete Employee" + '\n' + "5.View All Employees" + '\n' + "6.Import" + '\n' + "7.Export" + '\n'
                    + "8.Exit" + '\n' + "Select Any Option From the Menu :");

            int option = sc.nextInt();
            switch (option) {
                case 1:

                    System.out.print("Enter Employee name : ");
                    ename = sc.next();
                    //Generating Employee Id in service based Employee size
                    id = eser.createEmpid();
                    System.out.print("Enter Employee  Age : ");
                    age = sc.nextInt();
                    System.out.print("Enter Employee Designation : ");
                    designation = sc.next();
                    System.out.print("Enter Employee Department : ");
                    department = sc.next();
                    System.out.print("Enter Employee  Country : ");
                    country = sc.next();
                    System.out.print("Enter Employee Sal : ");
                    sal = sc.nextInt();
                    //Date Fields
                    LocalDate date = LocalDate.now();
                    LocalDateTime createTime = LocalDateTime.now();
                    LocalDateTime modifyTime = LocalDateTime.now();

                    Employee e = new Employee(id, ename, age, designation, department, country, sal);
                    //Calling Service to Call Employee
                    eser.createEmployee(id, e);

                    break;
                case 2:
                    System.out.println("Enter Employee Id");
                    id = sc.nextInt();
                    eser.viewEmployee(id);

                    break;
                case 3:
                    System.out.println("Enter Employee Id to Update");
                    id = sc.nextInt();

                    System.out.println("Enter Updated Employee Name");
                    ename = sc.next();
                    System.out.println("Enter Updated Employee  Age");
                    age = sc.nextInt();
                    System.out.println("Enter Updated Employee Designation");
                    designation = sc.next();
                    System.out.println("Enter Updated Employee Department");
                    department = sc.next();
                    System.out.println("Enter Updated Employee  Country");
                    country = sc.next();
                    System.out.println("Enter Updated Employee Sal ");
                    sal = sc.nextInt();
                    //Date Fields
                    LocalDate date1 = LocalDate.now();
                    LocalDateTime createTime1 = LocalDateTime.now();
                    LocalDateTime modifyTime1 = LocalDateTime.now();

                    Employee e1 = new Employee(id, ename, age, designation, department, country,
                            sal);
                    eser.updateEmployee(id, e1);
                    break;
                case 4:
                    System.out.println("Enter Employee Id");
                    id = sc.nextInt();
                    eser.deleteEmployee(id);
                    break;
                case 5:
                    eser.viewAllEmployees();
                    break;
                case 6:
                    Future<Boolean> importFuture = executorService.submit(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            System.out.println("Import Process on Thread name: " + Thread.currentThread().getName());
                            Thread.sleep(2000);
                            eser.ImportData();
                            eser.viewAllEmployees();
                            return true;
                        }
                    });
                    break;
                case 7:
                    Future<Boolean> exportFuture = executorService.submit(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            System.out.println("Import Process on Thread name: " + Thread.currentThread().getName());
                            Thread.sleep(2000);
                            eser.ExportData();
                            executorService.shutdown();
                            return true;
                        }
                    });
                    break;

                case 8:
                    executorService.shutdown();
                    return;

                default:
                    System.out.println("Select other option");
            }
            System.out.println("Do u want to continue :Y/N");
            text = sc.next();
        }
        while (text.equalsIgnoreCase("y"));


    }
}



