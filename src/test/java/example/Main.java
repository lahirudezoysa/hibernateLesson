package example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {


    public static void main(String[] args) {
        Student s1=new Student(1,"kamal",3.4);
        Student s2=new Student(2,"kamal",3.4);
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student u1=session.get(Student.class, 1);
        u1.setSName("lahiru");
        u1.setGpa(4.0);
        session.persist(s2);
        session.getTransaction().commit();

    }
}
