# Writing Basic JUnit Tests

This guide demonstrates how to write basic JUnit tests for a simple Java class.

---

## 1. Create a Java Class to Test

Example: `Calculator.java`
```java

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
}
```

---

## 2. Write JUnit Tests for These Methods

Example: `CalculatorTest.java`
```java

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(7, calc.add(3, 4));
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(1, calc.subtract(5, 4));
    }
}
```

---

## 3. Run Your Tests

- In your IDE, right-click the test class or method and select **Run**.
- Or use Maven/Gradle commands:
    - Maven: `mvn test`
    - Gradle: `gradle test`

---

## Notes

- Use `@Test` annotation from `org.junit.jupiter.api.Test` for JUnit 5.
- Use assertion methods like `assertEquals` to check expected results.

---

