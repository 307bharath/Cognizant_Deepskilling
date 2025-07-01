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
