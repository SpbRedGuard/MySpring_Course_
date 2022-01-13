package Hibernate_OneToMany_bi;

import Hibernate_OneToMany_bi.entity.Department;
import Hibernate_OneToMany_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

            // Работа с сессией может вызывать исключение Exception
            // Могут быть случаи, когда сессия может остаться не закрытой, для этого можно перенести
            // закрытие сессии в блок finally, а до блока try объявить сессию со значением null, в самом блоке try
            // в самом блоке try уже получать значение

            Session session = null;
        try {
            //Создание сессии
            session = factory.getCurrentSession();

            session.beginTransaction(); // открытие транзакции

            Employee employee = session.get(Employee.class, 2);

            session.delete(employee);

            session.getTransaction().commit(); // закрытие транзакции

            System.out.println("Done");
        }
       finally {
            session.close();
            factory.close();
        }

    }


}
