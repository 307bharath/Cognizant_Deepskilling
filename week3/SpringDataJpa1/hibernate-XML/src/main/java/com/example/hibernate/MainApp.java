package com.example.hibernate;

import com.example.hibernate.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Employee emp1 = new Employee("John", "Doe", 5000.0);
            session.save(emp1);

            List<Employee> employees = session.createQuery("FROM Employee").list();
            for (Employee e : employees) {
                System.out.println("Fetched: " + e);
            }

            Employee fetched = session.get(Employee.class, emp1.getId());
            System.out.println("Get by ID: " + fetched);

            session.delete(fetched);
            System.out.println("Deleted employee with ID: " + fetched.getId());

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
