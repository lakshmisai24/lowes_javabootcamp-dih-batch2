package EmployeeService;

import EmployeeModel.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintEmployeeStatistics {


    public long getEmployeeCountAgeGreaterThan(int age, Map<Integer, Employee> empMap) {
        long count = 0;
        for (Employee emp : empMap.values()) {
            if (emp.getAge() > age)
                count++;
        }
        System.out.println("1. "+ count + " Employees age is greater than given " + age);
        return count;

    }


    public List<Integer> getEmployeeIdsAgeGreaterThan(int age, Map<Integer, Employee> empMap) {
        Map<Integer, List<Integer>> countidlist = new HashMap<>();
        List<Integer> empids = new ArrayList<>();
        for (Employee emp : empMap.values()) {
            Integer id = emp.getEmpid();
            if (countidlist.containsKey(id)) {
                if (emp.getAge() > age) {
                    empids = countidlist.get(id);

                } else {
                    empids = countidlist.get(id);
                    countidlist.put(id, empids);

                }
            }
        }
        System.out.println("Employee Ids greater than given age is :");
        for (int x:empids) {
            System.out.println(x);
        }
        return empids;
    }


    public int getEmployeeCountByDepartment(Map<Integer, Employee> empMap) {
        List<Employee> emp = new ArrayList(empMap.values());
        Map<String, List<Employee>> EmpByDepartment = new HashMap<>();
        int count = 0;
        for (Employee p : emp) {
            if (!EmpByDepartment.containsKey(p.getDepartment())) {
                EmpByDepartment.put(p.getDepartment(), new ArrayList<>());
            }
            EmpByDepartment.get(p.getDepartment()).add(p);
            count++;
        }

        EmpByDepartment = emp.stream().collect(Collectors.groupingBy(Employee::getDepartment));


        System.out.println("Employees grouped by Department : " + EmpByDepartment.values().toArray());
        return count;
    }


    public void getAvgEmployeeAgeByDept(Map<Integer, Employee> empMap) {
        Employee p1=new Employee();
        List<Employee> emp = new ArrayList(empMap.values());
        Map<Object, Double> ageGroup= emp.stream().
                collect(Collectors.groupingBy(p->p.getDepartment(),Collectors.averagingDouble(p->p.getAge())));
        System.out.println(ageGroup);

    }

public void getDepartmentsHavMoreThanEmp(int n,Map<Integer, Employee> empMap){
    List<Employee> emp = new ArrayList(empMap.values());
    Map<Object, Long> deptGroup= emp.stream().
            collect(Collectors.groupingBy(p->p.getDepartment(),Collectors.counting()));

}

public void getEmployeeNameStartWithPrefix(String s,Map<Integer, Employee> empMap)
{
    List<String> emp = new ArrayList(empMap.values());
    Employee e=new Employee();
    Stream<String> s1 = emp.stream().filter(name-> e.getName().toString().startsWith(s));
    System.out.println(s1.collect(Collectors.toList()));

}

}





