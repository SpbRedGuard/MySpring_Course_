package hibernate_test.entity;

import hibernate_test.entity.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test2get {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // Работа с сессией может вызывать исключение Exception
        try {
            //Создание сессии
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Elena", "Petrova", "Sales", 450);

            session.beginTransaction(); // открытие транзакции
            session.save(emp); // сохранение объекта в БД Employee в строковом виде
            session.getTransaction().commit(); // закрытие транзакции

            int myIdEmp = emp.getId(); // создание переменной под ID (для будущего возврата значения из БД)
            session = factory.getCurrentSession(); // вызов сессии
            session.beginTransaction(); // открытие транзакции
            Employee employee = session.get(Employee.class, myIdEmp); // создание объекта из строки БД с указанием ID
            // (значение ID из переменной myIdEmp)
            session.getTransaction().commit(); // завершение транзакции
            System.out.println(employee);

            System.out.println("Done");
        }
        finally {
            factory.close();
        }

    }


}

