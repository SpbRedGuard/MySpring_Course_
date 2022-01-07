package hibernate_test.entity;

import hibernate_test.entity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

            // Работа с сессией может вызывать исключение Exception
        try {
            //Создание сессии
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Ivan", "Ivanov", "IT", 1000);

            session.beginTransaction(); // открытие транзакции
            session.save(emp); // сохранение объекта в БД Employee в строковом виде
            session.getTransaction().commit(); // закрытие транзакции

            System.out.println("Done");
        }
       finally {
            factory.close();
        }

    }


}
