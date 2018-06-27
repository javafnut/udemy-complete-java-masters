package com.ibexsys.playground.Lambda;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;


public class SimpleThreads {

    Logger logger = Logger.getLogger(SimpleThreads.class.getName());

    private List<Employee> employeeList = new ArrayList<Employee>();

    public SimpleThreads() {

        employeeList.add(new Employee("John Doe", 23));
        employeeList.add(new Employee("Dave Jones", 33));
        employeeList.add(new Employee("Jack Hill", 33));
    }


    // Note Lambda's cannot use ; for one statement
    public void Example1() {
        new Thread(() -> System.out.println("Printing from runnable - Example 1")).start();
    }

    public void Example2() {

        new Thread(() -> {
            System.out.println("Printing from runnable - Example 2-1");
            System.out.println("Printing from runnable - Example 2-2");
        }).start();
    }

    public void EmployeeListWithParamters() {

//        logger.info("Using non-lambda collections sort...");
//        // Traditional - COOL Stuff
//        Collections.sort(employeeList, new Comparator<Employee>(){
//            @Override
//            public int compare(Employee employee1, Employee employee2){
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });

        /*
           3 parts to the expression -
             1,-Argument list - Employee employee1, Employee employee2
             2. Arrow token ->
             3. Body - employee1.getName().compareTo(employee2.getName())
         */

        Collections.sort(employeeList, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for (Employee employee : employeeList) {
            logger.info("Employee name -> " + employee.getName());
        }

        logger.info("Using lambda collections sort...");
    }


    public void EmployeeListWithInferredParamters() {

        /*
           3 parts to the expression
             1, Argument list - Employee employee1, Employee employee2
             2. Arrow token ->
             3. Body - employee1.getName().compareTo(employee2.getName())
         */

        Collections.sort(employeeList, (emp1, emp2) ->
                emp1.getName().compareTo(emp2.getName()));

        for (Employee employee : employeeList) {
            logger.info("Employee name -> " + employee.getName());
        }

        logger.info("Using lambda collections sort inferred parameters ...");
    }


}


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
