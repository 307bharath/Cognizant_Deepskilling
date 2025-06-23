# Exercise 3: Assertions in JUnit

This exercise demonstrates how to use various JUnit assertions to validate your test results.

---

## 1. Write Tests Using Various JUnit Assertions

Example: `AssertionsTest.java`
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {
    @Test
    public void testAssertions() {
        // Assert equals
        assertEquals(5, 2 + 3);

        // Assert true
        assertTrue(5 > 3);

        // Assert false
        assertFalse(5 < 3);

        // Assert null
        assertNull(null);

        // Assert not null
        assertNotNull(new Object());
    }
}
```

---

## Common JUnit Assertions

- `assertEquals(expected, actual)` – checks if two values are equal.
- `assertTrue(condition)` – checks if a condition is true.
- `assertFalse(condition)` – checks if a condition is false.
- `assertNull(object)` – checks if an object is null.
- `assertNotNull(object)` – checks if an object is not null.

---
