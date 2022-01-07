package hibernate_test.entity;

import hibernate_test.entity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


     // Пример добавление/перезаписи объектов в БД

public class test4set {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // Работа с сессией может вызывать исключение Exception
        try {
            //Создание сессии
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 1);
            // emp.setSalary(1500); // запись другого значения salary таблицу БД
            // запись другого значения в БД с выбранным условием
            session.createQuery("update Employee set salary=1000" + "where name='Elena'").executeUpdate();

            session.getTransaction().commit(); // закрытие транзакции

            System.out.println("Done");
        }
        finally {
            factory.close();
        }

    }


}

