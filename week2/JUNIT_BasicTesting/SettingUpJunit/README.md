# Setting Up JUnit with JUnit Jupiter

This guide helps you set up JUnit (JUnit Jupiter) in your Java project and write your first unit test.

---

## 1. Create a New Java Project

- Use your preferred IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).
- Create a new Java project (e.g., `JUNIT_BasicTesting`).

---

## 2. Add JUnit Jupiter Dependency

**If using Maven, add to your `pom.xml`:**
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

**If using Gradle, add to your `build.gradle`:**
```groovy
testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2'
```

**If not using a build tool:**  
- Download the JUnit Jupiter JARs from [Maven Central](https://search.maven.org/artifact/org.junit.jupiter/junit-jupiter).
- Add them to your project's classpath.

---

## 3. Create a Test Class

Example: `CalculatorTest.java`
```java
package JUNIT_BasicTesting.SettingUpJunit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(3, 4);
        assertEquals(7, result);
    }
}
```

---

## 4. Run Your Tests

- In your IDE, right-click the test class or method and select **Run**.
- Or use Maven/Gradle commands:
    - Maven: `mvn test`
    - Gradle: `gradle test`

---

## Notes

- Make sure your test classes are in the correct test source directory (e.g., `src/test/java`).
- Use `org.junit.jupiter.api.Test` for JUnit Jupiter (JUnit 5).

---
