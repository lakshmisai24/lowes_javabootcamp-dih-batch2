import config.ApplicationConfig;
import dao.EmployeeDaoService;
import dao.EmployeeDaoServiceImpl;
import model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.StampedLock;

@Component
public class AppMain {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        ApplicationContext context  =new AnnotationConfigApplicationContext(ApplicationConfig.class);
         Employee emp = context.getBean("employee", Employee.class);
         EmployeeDaoServiceImpl edao = emp.getEdao();

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("---------------Employee Management application-------------");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Print Statistics");
            System.out.println("7. Import");
            System.out.println("8. Export");
            System.out.println("9. Exit");
            System.out.println("Enter the option: ");
            int number = sc.nextInt();
            switch (number) {
                case 1: // Create employee
                    edao.createemployee(readEmployee());
                    System.out.println("Employee has been added Succesfully ");
                    break;
                case 2: // View Employee
                    int empId = readEmployeeId();
                    emp = edao.get(empId);
                    printHeader();
                    printEmployee(emp);
                    break;
                case 3: // Update employee
                    int empIdToUpdate = readEmployeeId();
                    Employee empNew = readEmployee();
                    empNew.setEmpid(empIdToUpdate);
                    edao.updateemployee(empNew);
                    System.out.println("Employee has been updated Succesfully ");
                    break;
                case 4: // Delete Employee
                    int empIDToDelete = readEmployeeId();
                    edao.deleteemployee(empIDToDelete);
                    break;
                case 5: // View all Employees
                    List<Employee> employees = edao.displayemployees();
                    printEmployees(employees);

                    break;
                case 6: // Print Statistics
                    printStatistics();
                    break;
                case 7: // Import
                    Future<Boolean> importFuture = executorService.submit(() -> {
                        Thread.sleep(2000);
                        System.out.println("Import Process on Thread name: " + Thread.currentThread().getName());
                        edao.bulkImport();
                        return true;
                    });
                    break;
                case 8: // Export
                    Future<Boolean> exportFuture = executorService.submit(() -> {
                        Thread.sleep(2000);
                        System.out.println("Export Process on Thread name: " + Thread.currentThread().getName());
                        edao.bulkExport();
                        executorService.shutdown();
                        return true;
                    });
                    break;
                case 9:
                    executorService.shutdown();
                    return;
            }
        } while (true);

    }

    static int readEmployeeId() {
        do {
            try {
                System.out.println("Enter empID ");
                Scanner sc = new Scanner(System.in);
                int empId = sc.nextInt();
                return empId;
            } catch (InputMismatchException e) {
                System.out.println("Sorry you have entered invalid Employee ID");
            }
        } while (true);

    }

    static Employee readEmployee() {
        ApplicationContext ctx  =new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Employee emp2 = ctx.getBean("employee", Employee.class);
        EmployeeDaoServiceImpl edao1 = emp2.getEdao();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee details: ");
        System.out.println("Enter employee Name:  ");
        emp2.setName(sc.next());

        // validate age
        boolean valAgeStatus = true;
        do {
            try {
                System.out.println("Enter employee Age: ");
                String message = "Invalid age: Enter age > 20 and < 60 : ";
                emp2.setAge(sc.nextInt());
                valAgeStatus = edao1.validate(emp2, message, (employee) -> emp2.getAge() >= 20 && employee.getAge() <= 60);
            } catch (InputMismatchException e) {
                System.out.println("Sorry you have entered invalid Age ");
                sc.next();  // if exception comes, we should move to the next token
                // https://stackoverflow.com/questions/6374623/java-util-scanner-why-my-nextdouble-does-not-prompt
                valAgeStatus = false;
            }
        } while (!valAgeStatus);

        System.out.println("Enter employee Designation: ");
        emp2.setDesignation(sc.next());
        System.out.println("Enter employee Department: ");
        emp2.setDepartment(sc.next());
        System.out.println("Enter employee Country: ");
        emp2.setCountry(sc.next());

        // validate Salary
        boolean valSalStatus = true;
        do {
            try {
                System.out.println("Enter employee Salary: ");
                String message = "Invalid salary: Enter salary > 0 ";
                emp2.setSalary((int) sc.nextDouble());
                valSalStatus = edao1.validate(emp2, message, (employee) -> emp2.getSalary() > 0);
            } catch (InputMismatchException e) {
                System.out.println("Sorry you have entered invalid Salary ");
                sc.next();  // if exception comes, we should move to the next token
                // https://stackoverflow.com/questions/6374623/java-util-scanner-why-my-nextdouble-does-not-prompt
                valSalStatus = false;
            }
        } while (!valSalStatus);


        // validate Date of Joining
        boolean valDojStatus = true;
        do {
            try {
                System.out.println("Enter Date of joining (doj) in dd-mm-yyyy  format: ");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");  // doubt
                LocalDate doj = LocalDate.parse(sc.next(), formatter);
                emp2.setDateofjoining(doj);
                valDojStatus = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid Date format, Enter date in dd-mm-yyyy  format");
                valDojStatus = false;
            }
        } while (!valDojStatus);
        return emp2;
    }

    static void printEmployee(Employee employee) {
        System.out.println(employee.getEmpid() + "\t" + employee.getName() + "\t\t" + employee.getAge() + "\t\t\t" +
                employee.getDesignation() + "\t\t" + employee.getDepartment() + "\t\t" +
                employee.getCountry() + "\t\t" + employee.getSalary() + "\t\t\t" + employee.getDateofjoining() + "\t\t" +
                employee.getCreatedTime() + "\t\t\t" + employee.getModifiedtime());
    }

    static void printEmployees(List<Employee> employees) {
        printHeader();
        for (Employee employee : employees) {
            printEmployee(employee);
        }
    }

    static void printHeader() {
        System.out.println("EmpId \t Name \t Age \t Designation \t Department \t Country \t Salary \t Doj \t\t CreatedTime \t\t\t ModifiedTime");
    }

    static void printStatistics() {
        ApplicationContext ctx  =new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Employee emp1 = ctx.getBean("employee", Employee.class);
        EmployeeDaoServiceImpl edao1 = emp1.getEdao();

        System.out.println(" Number of Employees older than thirty years:  " +
                edao1.getEmployeeCountAgeGreaterThan(e -> e.getAge() > 30));
        System.out.println("List of Employee Ids older than 30 years: " +
                edao1.getEmployeeIdsAgeGreaterThan(30));
        System.out.println("Employee count by Department: " +
                edao1.getEmployeeCountByDepartment());
        System.out.println("Employee count by Department sorted: " +
                edao1.getEmployeeCountByDepartmentOrdered());
        System.out.println("Average Employee age by Department: " +
                edao1.getAvgEmployeeAgeByDept());
        System.out.println("List Departments have more than 3 employees: " +
                edao1.getDepartmentsHaveEmployeesMoreThan(2));
        System.out.println("List Employees starts with " + "'A':" +
                edao1.getEmployeeNamesStartsWith("A"));
        System.out.println("Average Employee Service by Department: " +
                edao1.getAvgEmployeeServiceByDept());
    }
}







		


