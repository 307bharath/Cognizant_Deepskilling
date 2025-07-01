# 🧠 Hands-on 4: Difference Between JPA, Hibernate, and Spring Data JPA

---

## 1. Java Persistence API (JPA)

- JSR 338 specification for object-relational mapping (ORM)
- Defines how Java objects are persisted to relational databases
- Does NOT provide an implementation
- Requires a provider like Hibernate, EclipseLink, etc.

## Example providers:
- Hibernate
- EclipseLink
- OpenJPA

### 🛠️ Code Example: JPA with Hibernate (manually)

**JAVA**
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeePU");
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();

try {
    tx.begin();
    em.persist(employee);  // Save the entity
    tx.commit();
} catch (Exception e) {
    if (tx.isActive()) tx.rollback();
} finally {
    em.close();
    emf.close();
}
```
**persistence.xml**
```xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.2">
  <persistence-unit name="employeePU">
    <class>com.example.Employee</class>
    <properties>
      <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
      <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/hibernatedb"/>
      <property name="javax.persistence.jdbc.user" value="root"/>
      <property name="javax.persistence.jdbc.password" value="password"/>
      <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
      <property name="hibernate.hbm2ddl.auto" value="update"/>
    </properties>
  </persistence-unit>
</persistence>
```
---

## 2. Hibernate
- A popular ORM tool that provides:
    - Concrete implementation of the JPA specification
    - Additional features beyond the JPA standard
- Acts as the engine behind many JPA setups
- Can be used with or without JPA annotations

### Code Example: Native Hibernate
```java

---

public Integer addEmployee(Employee employee){
    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {
        tx = session.beginTransaction();
        employeeID = (Integer) session.save(employee);
        tx.commit();
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }

    return employeeID;
}
```
---

## 3. Spring Data JPA
- Part of the Spring Data umbrella project
- Provides a higher-level abstraction over JPA
- Automatically generates repositories for CRUD operations
- Reduces boilerplate (no need for DAO implementation)
- Integrates tightly with Spring Boot, Spring MVC, and Spring Transactions

### Code Example: Spring Data JPA
**EmployeeRepository.java**
```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // No implementation needed
}
```
**EmployeeService.java**
```java

@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```
---

🆚 Summary Table
| Feature                | JPA (Standard)     | Hibernate                     | Spring Data JPA                     |
|------------------------|--------------------|-------------------------------|-------------------------------------|
| Specification or Tool  | Specification      | ORM Tool & JPA implementation | Abstraction over JPA/Hibernate      |
| Boilerplate Code       | Moderate           | High                          | Very Low                            |
| Configuration File     | `persistence.xml`  | `hibernate.cfg.xml`           | `application.properties` or YAML   |
| Transaction Handling   | Manual             | Manual                        | Auto via `@Transactional`           |
| Session Management     | EntityManager      | Session                       | Handled by Spring                   |
| Repository Abstraction | No                 | No                            | Yes (`CrudRepository`, `JpaRepository`) |
| Auto Table Generation  | Yes (via provider) | Yes                           | Yes                                 |

