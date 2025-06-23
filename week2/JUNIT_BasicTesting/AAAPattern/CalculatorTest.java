package JUNIT_BasicTesting.AAAPattern;
import JUNIT_BasicTesting.WritingBasicJUnitTests.Calculator;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Arrange: Initialize resources before each test
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        // Cleanup: Release resources after each test
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Arrange is done in setUp()
        // Act
        int result = calculator.add(2, 3);
        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        // Arrange is done in setUp()
        // Act
        int result = calculator.subtract(5, 2);
        // Assert
        assertEquals(3, result);
    }
}
