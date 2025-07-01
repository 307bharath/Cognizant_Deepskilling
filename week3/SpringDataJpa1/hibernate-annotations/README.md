# ✅ Hibernate Annotations Demo

This project demonstrates how to use **Hibernate ORM with Annotations** to perform CRUD operations using a simple `Employee` entity mapped to a relational database.

---

## 📌 Topics Covered

- Object-to-Relational Mapping with Hibernate
- Annotation-based Entity Configuration
- Hibernate Configuration (`hibernate.cfg.xml`)
- End-to-End Example with Maven

---

## 🧱 Technologies Used

- Java 8+
- Hibernate Core 5.x
- MySQL
- Maven
- JDBC
- JPA (Jakarta Persistence)

---
## 🔷 Explanation of Annotations & Configuration

### 1. **@Entity**
Declares the class as an entity.
Tells Hibernate that this class should be mapped to a table.
Must be used with a no-argument constructor.

### 2. **@Table(name = "EMPLOYEE")**
Specifies the table name in the database that this entity maps to.
Optional if the class name matches the table name.

### 3. **@Id**
Declares the primary key of the entity.
Must be unique and not null.

### 4. **@GeneratedValue**
Specifies the strategy for generating primary key values.
**Common strategies**: AUTO, IDENTITY, SEQUENCE, TABLE.
**Example**: @GeneratedValue(strategy = GenerationType.IDENTITY)

### 5. **@Column(name = "column_name")**
Maps a Java field to a specific column in the table.
Can also include parameters like nullable, length, etc.

---

## 📁 Project Structure

hibernate-annotations-demo/
│
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── example/
│ ├── App.java
│ └── Employee.java
│
├── resources/
│ └── hibernate.cfg.xml
│
├── pom.xml
└── README.md


---

## 🧾 Object-to-Relational Mapping (`Employee.java`)

```java
package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    // Getters and Setters
}
```
---

##  Hibernate Configuration (hibernate.cfg.xml)
```xml

<hibernate-configuration>
  <session-factory>
    <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernatedb</property>
    <property name="hibernate.connection.username">root</property>
    <property name="hibernate.connection.password">password</property>

    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.hbm2ddl.auto">update</property>

    <mapping class="com.example.Employee"/>
  </session-factory>
</hibernate-configuration>
```
## Key Configuration Elements
### Property	Description
* hibernate.connection.driver_class	JDBC Driver class (e.g., for MySQL)
* hibernate.connection.url	JDBC connection string
* hibernate.connection.username	Database username
* hibernate.connection.password	Database password
* hibernate.dialect	SQL dialect Hibernate should use (e.g., MySQLDialect)
* hibernate.show_sql	Logs SQL statements in the console
* hibernate.hbm2ddl.auto	Schema management (create, update, validate, none)

---

##  Main Application (App.java)
```java

package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee();
        emp.setFirstName("John");
        emp.setLastName("Doe");
        emp.setSalary(50000);

        session.save(emp);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Employee saved successfully!");
    }
}
```
---

## Maven Configuration (pom.xml)
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>hibernate-annotations-demo</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.6.15.Final</version>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.0.33</version>
        </dependency>
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>2.2.3</version>
        </dependency>
    </dependencies>
</project>
```
---

##  How to Run the Project

### Steps
*Create the MySQL database

```sql
CREATE DATABASE hibernatedb;
Update DB credentials
```

* Edit hibernate.cfg.xml with your MySQL username and password.

* Compile and Run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.example.App"
```
## You should see:
```nginx
Employee saved successfully!
```
