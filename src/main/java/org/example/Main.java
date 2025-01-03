package org.example;

import org.example.util.GetSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // #1 Create Student objects
        Student s1 = new Student(1, "kamal", 3.4, null, null);
        Student s2 = new Student(2, "amal", 2.4, null, null);

        // #2 Create Laptop objects and associate them with students
        Laptop l1 = new Laptop(1, "Dell Inspiron", s1);
        Laptop l2 = new Laptop(2, "HP Pavilion", s1);
        Laptop l3 = new Laptop(3, "Asus Vivobook", s2);

        // #3 Create Course objects
        Course c1 = new Course(1, "Math", null);
        Course c2 = new Course(2, "Science", null);

        // #4 Associate Students with Courses
        s1.setCourses(List.of(c1, c2));
        s2.setCourses(List.of(c1));

        // #5 Associate Students with Laptops
        s1.setLaptops(List.of(l1, l2));
        s2.setLaptops(List.of(l3));

        // Initialize SessionFactory
        SessionFactory sessionFactory = new GetSessionFactory().getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Persist Students (Cascades to Laptops and Courses)
            session.persist(s1);
            session.persist(s2);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }

        System.out.println("Students, Laptops, and Courses saved successfully!");
    }
}
