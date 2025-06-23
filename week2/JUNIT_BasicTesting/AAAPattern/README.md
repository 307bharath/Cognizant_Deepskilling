# Exercise 4: Arrange-Act-Assert (AAA) Pattern, Test Fixtures, Setup and Teardown Methods in JUnit

This exercise demonstrates how to organize your tests using the Arrange-Act-Assert (AAA) pattern and how to use setup and teardown methods in JUnit.

---

## 1. Arrange-Act-Assert (AAA) Pattern

- **Arrange:** Set up the objects and conditions needed for the test.
- **Act:** Perform the action to be tested.
- **Assert:** Check that the expected outcome occurred.

---

## 2. Setup and Teardown Methods

- Use `@BeforeEach` to run code before each test (setup).
- Use `@AfterEach` to run code after each test (teardown).

---

## Example: Calculator Test with AAA Pattern

```java
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
```

---

## Notes

- `@BeforeEach` and `@AfterEach` are from JUnit Jupiter (JUnit 5).
- The AAA pattern makes tests easy to read and maintain.
- Setup and teardown methods help manage test resources and avoid code duplication.

---
