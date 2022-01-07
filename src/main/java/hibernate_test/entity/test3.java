package hibernate_test.entity;

import hibernate_test.entity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class test3 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // Работа с сессией может вызывать исключение Exception
        try {
            //Создание сессии
            Session session = factory.getCurrentSession();

            session.beginTransaction(); // открытие транзакции

            List <Employee> emp = session.createQuery("from Employee").getResultList();

            for (Employee e: emp){
                System.out.println(e);
            }

            session.getTransaction().commit(); // закрытие транзакции

            System.out.println("Done");
        }
        finally {
            factory.close();
        }

    }


}
