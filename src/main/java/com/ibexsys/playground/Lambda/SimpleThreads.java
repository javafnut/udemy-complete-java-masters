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


    /********************************************************************************************
     *   Lambda replaces this code
        Collections.sort(employeeList, new Comparator<Employee>(){
            @Override
            public int compare(Employee employee1, Employee employee2){
                return employee1.getName().compareTo(employee2.getName());
            }
        });

         3 parts to the expression -
         1,-Argument list - Employee employee1, Employee employee2
         2. Arrow token ->
         3. Body - employee1.getName().compareTo(employee2.getName())
     *********************************************************************************************/
    public List<Employee> EmployeeListWithParameters(List<Employee> employeeList) {

        Collections.sort(employeeList, (Employee employee1, Employee employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        return employeeList;
    }


    public List<Employee> EmployeeListWithInferredParameters(List<Employee> employeeList) {


        Collections.sort(employeeList, (emp1, emp2) ->
                emp1.getName().compareTo(emp2.getName()));

        return employeeList;
    }

    public List<Employee> getEmployeeSortedListByName(List<Employee> employeeList){

        // Sort by name
        Collections.sort(employeeList, (emp1, emp2) ->
                    emp1.getName().compareTo(emp2.getName()));

        return employeeList;
    }

    public List<Employee> getEmployeeSortedListByAge(List<Employee> employeeList){

         // Sort by age
        Collections.sort(employeeList, (emp1, emp2) ->  emp1.getAge().compareTo(emp2.getAge()));

        return employeeList;
    }
}

class Employee {
    private String name;
    private Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
