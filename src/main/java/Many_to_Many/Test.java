package Many_to_Many;

import Many_to_Many.Entity.Child;
import Many_to_Many.Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
        session = factory.getCurrentSession();

        Section section1 = new Section("Football");

        Child child2 = new Child("Maya", 7);
        Child child3 = new Child("Alexey", 5);
        Child child4 = new Child("Artem", 12);

        section1.addChildToSection(child2);
        section1.addChildToSection(child3);
        section1.addChildToSection(child4);

        session.beginTransaction();

        session.save(section1);

        session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();

        }
    }
}
