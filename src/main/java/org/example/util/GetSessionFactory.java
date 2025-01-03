package org.example.util;

import org.example.Course;
import org.example.Laptop;
import org.example.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;
import java.util.Properties;

public class GetSessionFactory {
    private static SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
     final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(Student.class)
                            .addAnnotatedClass(Laptop.class)
                            .addAnnotatedClass(Course.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }
        catch (Exception e) {

            StandardServiceRegistryBuilder.destroy(registry);
        }
        return sessionFactory;
    }
}
