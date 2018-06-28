package com.ibexsys.playground.Lambda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleThreadsTest {

    private SimpleThreads simple;
    private List<Employee> employeeList = new ArrayList<Employee>();

    @Before
    public void setUp() throws Exception {
        simple = new SimpleThreads();

        employeeList.add(new Employee("John Doe", 23));
        employeeList.add(new Employee("Dave Jones", 20));
        employeeList.add(new Employee("Abe Hill", 33));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void SimplePrintlnExamples() {

        simple.Example1();
        simple.Example2();
    }

    @Test
    public void EmployeeListTest() {

        List<Employee> list1 = simple.EmployeeListWithInferredParameters(employeeList);
        assertTrue(employeeList.size() == list1.size());


        List<Employee> list2 = simple.EmployeeListWithParameters(employeeList);
        assertTrue(employeeList.size() == list2.size());

        List<Employee> listByName = simple.getEmployeeSortedListByName(employeeList);
        assertTrue(listByName.get(0).getName().equals("Abe Hill"));

        List<Employee> listByAge = simple.getEmployeeSortedListByAge(employeeList);
        assertTrue(listByName.get(0).getAge() == 20);

    }
}