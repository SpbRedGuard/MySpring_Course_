package aop;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary {

    public String getBook () {
        System.out.println("Мы берём книку из UniLibrary");
        return "Война и Мир";
    }

    public String returnBook () {
        int a = 10/0;
        System.out.println("Мы возвращаем книгу в UniLibrary");
        System.out.println("________________________________");
        return "Война и Мир";
    }

    public void getMagazine () {
        System.out.println("Мы берём книку из Magazine");
        System.out.println("____________________________");
    }

    public void returnMagazine () {
        System.out.println("Мы возвращаем книгу в Magazine");
        System.out.println("________________________________");
    }

    public void addBook (String person_name, Book book) {
        System.out.println("Мы добавляем книгу в UniLibrary");
        System.out.println("________________________________");
    }

    public void addMagazine () {
        System.out.println("Мы добавляем журнал в UniLibrary");
        System.out.println("________________________________");
    }
}
