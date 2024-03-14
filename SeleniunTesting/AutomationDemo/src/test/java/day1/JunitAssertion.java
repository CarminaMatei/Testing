package day1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class JunitAssertion {

    @Test
    public void testAssertTrueFalse(){
        assertTrue(5>4, "5 is grated than 4");
        assertFalse(4>5, "4 is not grather than 5");
    }

    @Test
    public void testNotNull(){
        Object dog = new Object();
        assertNotNull(dog);
    }

    @Test
    public void testNull(){
        Object cat = null;
        assertNull(cat, "the cat should be null");
    }

    @Test
    public void testAssertEquals() {
        int i = 1;
        assertEquals(2,++i);
    }

    @Test
    public void testAssertNotEquals(){
        int i = 1;
        assertNotEquals(2, i++);
    }

    @Test
    public void testAssertArrayEquals(){
        int[] numbers = {12, 3, 4, 1};
        int[] expected = {1, 3, 4, 12};

        Arrays.sort(numbers);

        assertArrayEquals(expected, numbers, "Arrays should be equal");
    }

    @Test
    public void testAssertSameNotSame(){
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        assertSame(s1,s2);

        assertNotSame(s1,s3);
    }

//    @Test
//    public void testFailMethod(){
//        fail("Service is under development");
//    }

    @Test
    void trueAssumption(){
        assumeTrue(5 >4);
        assertEquals( 5+2 , 7);
    }

    @Test
    void falseAssumption(){
        assumeTrue(5 <44);
        assertEquals( 5+2 , 7);
    }

    @Test
    void assumtionThat(){
        String s1= "a string";
        assumingThat(s1.equals("a string"),
                () -> assertEquals(5+2,7));
    }
}
