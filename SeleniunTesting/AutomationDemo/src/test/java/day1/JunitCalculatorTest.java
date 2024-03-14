package day1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitCalculatorTest {

    BasicCalculator calculator;

    @BeforeEach
    public void startTest() {
        System.out.println("Run test");
        calculator = new BasicCalculator();
    }

    @AfterEach
    public void stopTest(){
        System.out.println("Finish test");
    }

    @Test
    public void testAdd(){
        System.out.println("Running test add");
        int result = calculator.add(2,3,4,5);
        assertEquals(14, result);
    }

    @Test
    public void testMultiply(){
        System.out.println("Running test multiply");
        int result = calculator.multiply(2,1,3);
        assertEquals(6, result);
    }

}
