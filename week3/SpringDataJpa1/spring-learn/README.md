# 🌍 Country Management Service – Spring Data JPA (Hands-On 5 to 9)

This Spring Boot application demonstrates CRUD operations for managing country data using **Spring Data JPA** and **MySQL**. All requirements from Hands-on Tasks 5 through 9 have been implemented successfully and tested using a service class.

---

## ✅ Hands-on Task Summary

### 🧪 Hands-on 5: Hibernate Configuration and Data Initialization
- Configured `spring.jpa.hibernate.ddl-auto=validate` to ensure schema verification at startup.
- Added `data.sql` to populate the `country` table with real-world country data.
- Ensured schema matches the `Country` entity and database table exactly.
- Verified that the `country` table exists to avoid `SchemaValidationException`.

---

### 🔍 Hands-on 6: Find Country by Code
- Created a custom exception `CountryNotFoundException` under `service.exception`.
- Added the method:
```java
   public Country findCountryByCode(String code) throws CountryNotFoundException {
        return countryRepository.findById(code)
                .orElseThrow(() -> new CountryNotFoundException("Country not found"));
    }
``` 
- Wrapped repository access in an Optional and threw exception if country not found.
- Wrote a test method getAllCountriesTest() inside Application.java and invoked it via main() to validate lookup by "IN".
```java
private static void getAllCountriesTest() throws CountryNotFoundException {
}
```
---

### Hands-on 7: Add a New Country
- Implemented:
```java
 public void addCountry(Country country) {
    }
```
- Used countryRepository.save() to persist a new country record.
- Wrote testAddCountry() to insert and validate a new entry ("XX" - Xanadu) in the database.

---

### Hands-on 8: Update Country Name
- Added:
```java
public void updateCountry(String code, String name){

}
```
- Used findById() to retrieve the existing country and updated its name using setName(), followed by save().
- Verified the update with testUpdateCountry() which modified "XX" to "Xenovia".

---

### Hands-on 9: Delete Country
- Implemented:
```java
public void deleteCountry(String code){

}
```
- Used countryRepository.deleteById(code) to remove a country.
- Verified deletion in testDeleteCountry() using a follow-up lookup.

---

### Tech Stack
- Spring Boot
- Spring Data JPA
- MySQL Database
- Hibernate ORM
- Maven
- SLF4J Logging

---

### Tests & Output
- All operations are logged using SLF4J. You can observe:
    - SELECT, INSERT, UPDATE, DELETE Hibernate queries
    - Test validation logs like:
        - Hibernate: select c1_0.co_code,c1_0.co_name from country c1_0 where c1_0.co_code=?
        - Hibernate: insert into country (co_name,co_code) values (?,?)
        - Hibernate: update country set co_name=? where co_code=?
        - Hibernate: delete from country where co_code=?

---

### How to Run
- Ensure MySQL is running and database is created.
- Update application.properties with your DB credentials.
- Place data.sql in src/main/resources.
- Run using your IDE or:
```bash
mvn clean spring-boot:run
```
