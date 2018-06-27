package com.ibexsys.playground.Lambda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleThreadsTest {

    private SimpleThreads simple;

    @Before
    public void setUp() throws Exception {
        simple = new SimpleThreads();
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

        simple.EmployeeListWithParamters();
        simple.EmployeeListWithInferredParamters();
    }


}