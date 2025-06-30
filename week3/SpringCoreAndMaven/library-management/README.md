# 📚 Library Management (Spring Core - Exercises 4 to 8)

This project demonstrates core Spring Framework concepts such as:

* Maven setup
* XML-based and annotation-based configuration
* Dependency Injection (constructor and setter)
* Spring AOP with AspectJ

> ✅ **Exercises 4 to 8 are implemented in this single Maven project.**

---

## ✅ Exercise Overview

| Exercise | Description                                      |
| -------- | ------------------------------------------------ |
| 4        | Create and configure Maven project with Spring   |
| 5        | Configure Spring IoC container using XML         |
| 6        | Use annotation-based bean definitions            |
| 7        | Implement constructor and setter injection       |
| 8        | Implement AOP for logging method execution times |

---

## 🧹 Exercise 4: Maven Project Setup

**pom.xml**

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.30</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>5.3.30</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.21</version>
    </dependency>
</dependencies>

<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.10.1</version>
      <configuration>
        <source>1.8</source>
        <target>1.8</target>
      </configuration>
    </plugin>
  </plugins>
</build>
```

---

## ⚙️ Exercise 5: Spring IoC Configuration (XML)

**applicationContext.xml**

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
         http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
         http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd
         http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">

    <context:component-scan base-package="com.library" />
    <aop:aspectj-autoproxy />
    <bean id="loggingAspect" class="com.library.aspect.LoggingAspect"/>
</beans>
```

---

## 📾 Exercise 6: Annotation-Based Bean Configuration

**BookRepository.java**

```java
@Repository
public class BookRepository {
    public String getBookTitle() {
        return "Clean Code";
    }
}
```

**BookService.java**

```java
@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        System.out.println("BookService: no-arg constructor");
    }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("Book: " + bookRepository.getBookTitle());
    }
}
```

---

## 📉 Exercise 7: Constructor and Setter Injection

Already handled in `BookService`:

* Constructor is available for possible injection (not used by Spring here)
* Setter is annotated with `@Autowired` for setter-based DI

---

## 🪝 Exercise 8: Spring AOP (Aspect-Oriented Programming)

**LoggingAspect.java**

```java
@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.library.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method: " + joinPoint.getSignature());
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("After method: " + joinPoint.getSignature());
        System.out.println("Execution time: " + duration + "ms");
        return result;
    }
}
```

---

## 🚀 How to Run

**MainApp.java**

```java
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);
        bookService.displayBook();
    }
}
```

### Run via Maven:

```bash
mvn compile exec:java -Dexec.mainClass=com.library.MainApp
```

---

## 📌 Notes

* Uses **Spring 5.3.x** for compatibility with XML + annotation configs.
* No web module or DB needed; purely focused on Spring Core concepts.

---

## 📁 Package Structure

```
com.library
├── MainApp.java
├── service/
│   └── BookService.java
├── repository/
│   └── BookRepository.java
└── aspect/
    └── LoggingAspect.java
```

---

