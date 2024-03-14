package day1;

import org.junit.jupiter.api.*;

public class JunitAnnotation {

    @BeforeAll
    public static void beforeAllMethod(){
        System.out.println("I'm before all method!\n");
    }

    @BeforeEach
    public void beforeEachMethod(){
        System.out.println("I'm before each method!");
    }

    @Test
    public void test1(){
        System.out.println("I'm test 1!");
    }

    @Test
    public void test2(){
        System.out.println("I'm test 2!");
    }

    @Disabled
    public void test3(){
        System.out.println("I'm disabled test 3!");
    }

    @Test
    @DisplayName("My test name")
    public void test4(){

    }

    @RepeatedTest(2)
    public void test5(){
        System.out.println("Hello world! ");
    }

    @AfterEach
    public void  afterEachMethod(){
        System.out.println("I'm after each method!\n");
    }

    @AfterAll
    public static void  afterAllMethod(){
        System.out.println("I'm after all method!");
    }

}
