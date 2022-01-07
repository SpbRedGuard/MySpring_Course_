package Hibernate_test2;


import Hibernate_test2.entity.Detail;
import Hibernate_test2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

            // Работа с сессией может вызывать исключение Exception
            // Могут быть случаи, когда сессия может остаться не закрытой, для этого можно перенести
            // закрытие сессии в блок finally, а до блока try объявить сессию со значением null, в самом блоке try
            // в самом блоке try уже получать значение

            Session session = null;
        try {
            //Создание сессии
            session = factory.getCurrentSession();
            // перед стартом транзакции можно создать объект для таблицы БД employee из объекта класса Employee
            Employee employee = new Employee("Maria", "Bulkina", "Sales", 1700);

            // и объект для таблицы detail из объекта класса detail
            Detail detail = new Detail("Piter", "9516555732", "Bulka@Gmail.ru" );
            employee.setEmpDetails(detail);

            session.beginTransaction(); // открытие транзакции
            session.save(employee); // сохранение объекта в БД Employee в строковом виде
            session.getTransaction().commit(); // закрытие транзакции

            System.out.println("Done");
        }
       finally {
            session.close();
            factory.close();
        }

    }


}
