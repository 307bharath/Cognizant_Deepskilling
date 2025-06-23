package JUNIT_BasicTesting.WritingBasicJUnitTests;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 4);
        assertEquals(7, result);
    }
    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }
    @Test
    public void testMultiply() {    
        Calculator calc = new Calculator();
        int result = calc.multiply(3, 4);
        assertEquals(12, result);
    }
    @Test
    public void testDivide() {
        Calculator calc = new Calculator();
        int result = calc.divide(12, 4);
        assertEquals(3, result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {  
        Calculator calc = new Calculator();
        calc.divide(12, 0); // This should throw an IllegalArgumentException
    }
}