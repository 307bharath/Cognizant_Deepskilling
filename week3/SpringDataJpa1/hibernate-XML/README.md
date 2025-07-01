Here's a **complete walkthrough and explanation** of **Hands-on 2: Hibernate XML Config Implementation**

---

## 🔧 Hibernate XML Configuration — Object-Relational Mapping (ORM)

### ✅ What is Hibernate XML Mapping?

Hibernate uses XML configuration to map **Java classes (objects)** to **database tables**, and **Java class fields** to **table columns**.

### 🔹 Example — `Employee.hbm.xml`:

```xml
<hibernate-mapping>
  <class name="Employee" table="EMPLOYEE">
    <id name="id" column="ID">
      <generator class="native"/>
    </id>
    <property name="firstName" column="FIRST_NAME"/>
    <property name="lastName" column="LAST_NAME"/>
    <property name="salary" column="SALARY"/>
  </class>
</hibernate-mapping>
```

#### 🔍 What this does:

| Java Class Field | Database Column |
| ---------------- | --------------- |
| `id`             | `ID`            |
| `firstName`      | `FIRST_NAME`    |
| `lastName`       | `LAST_NAME`     |
| `salary`         | `SALARY`        |

Hibernate reads this mapping and knows how to persist/fetch `Employee` objects into/from the `EMPLOYEE` table.

---

##  Core Concepts in Hibernate (XML-Based Implementation)

### 1. **SessionFactory**

* It's a **thread-safe** heavyweight object used to create **Sessions**.
* Built once per application, typically at startup.
* Reads from `hibernate.cfg.xml` and `.hbm.xml` mapping files.

```java
SessionFactory factory = new Configuration().configure().buildSessionFactory();
```
---

### 2. **Session**

* Represents a **connection between your app and the database**.
* Not thread-safe.
* Used to **persist, retrieve, delete, and update** objects.

```java
Session session = factory.openSession();
```
---

### 3. **Transaction**

* Used to wrap a series of Hibernate operations into a **single unit of work**.
* Needed to **ensure data consistency**.

```java
Transaction tx = session.beginTransaction();
```

---

### 4. **beginTransaction()**

* Begins a new transaction.
* Used before performing insert, update, or delete operations.

```java
Transaction tx = session.beginTransaction();
```

---

### 5. **commit()**

* Commits the changes to the database (makes them permanent).
* Called after all successful operations.

```java
tx.commit();
```

---

### 6. **rollback()**

* If an error occurs, this cancels all operations in the current transaction.

```java
tx.rollback();
```

---

### 7. **session.save(Object)**

* Saves a new object to the database.
* Returns the generated identifier (usually primary key).

```java
Integer empId = (Integer) session.save(employee);
```

---

### 8. **session.createQuery().list()**

* Executes an HQL (Hibernate Query Language) query to fetch data.
* Returns a list of results.

```java
List employees = session.createQuery("FROM Employee").list();
```

---

### 9. **session.get(Class, id)**

* Fetches a record by primary key (`id`).
* Returns `null` if no record found.

```java
Employee e = session.get(Employee.class, 101);
```

---

### 10. **session.delete(Object)**

* Deletes the given object from the database.

```java
session.delete(employee);
```

---

## 📂 Typical File Structure in XML-based Hibernate Project

text```
hibernate-xml-demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/hibernate/
│   │   │       ├── model/
│   │   │       │   └── Employee.java
│   │   │       └── MainApp.java
│   │   └── resources/
│   │       ├── hibernate.cfg.xml
│   │       └── Employee.hbm.xml
├── pom.xml

---

## Sample Flow (Main Program)

```java
SessionFactory factory = new Configuration().configure().buildSessionFactory();
Session session = factory.openSession();
Transaction tx = null;

try {
    tx = session.beginTransaction();
    
    // Create
    Employee emp = new Employee("John", "Doe", 5000);
    session.save(emp);
    
    // Read
    List employees = session.createQuery("FROM Employee").list();
    
    // Update
    emp.setSalary(6000);
    session.update(emp);
    
    // Delete
    session.delete(emp);
    
    tx.commit();
} catch (Exception e) {
    if (tx != null) tx.rollback();
    e.printStackTrace();
} finally {
    session.close();
}
```

---

## ✅ Summary Table

| Operation              | Description                          |
| ---------------------- | ------------------------------------ |
| `hibernate.cfg.xml`    | DB + mapping configuration           |
| `*.hbm.xml`            | Object-table mapping                 |
| `SessionFactory`       | Creates sessions, built once per app |
| `Session`              | Used for CRUD operations             |
| `Transaction`          | Ensures consistency in DB operations |
| `save()`               | Insert new object                    |
| `get()`                | Fetch object by ID                   |
| `createQuery().list()` | Fetch multiple records using HQL     |
| `commit()`             | Apply changes to DB                  |
| `rollback()`           | Undo changes if error occurs         |
| `delete()`             | Delete object from DB                |

---
## 🚀 How to Run

bash
```bash
Copy code
mvn clean compile exec:java -Dexec.mainClass="com.example.hibernate.MainApp"
```
### This will:

* Create an in-memory H2 database

* Insert an Employee

* List all employees

* Fetch an employee by ID

* Delete the employee

* Commit the transaction

