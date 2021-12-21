package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {

    public static void main(String[] args) {

        System.out.println("Method Main starts");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary library = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = library.returnBook();
        System.out.println("В библиотеку вернули книгу: " + bookName);
        context.close();

        System.out.println("Method Main ends");
    }

}

