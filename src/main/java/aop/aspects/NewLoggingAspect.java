package aop.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class NewLoggingAspect {

    @Around("execution (public String returnBook())")
    public Object aroundReturnBookLoggingAdvice (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку " + "пытяются вернуть книгу ");

        long begin = System.currentTimeMillis();

        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("Было поймано исключение: " + e);
            // targetMethodResult = "неизвестое название книги";
            // - в этом случае из этого метода вернётс значение в вызвавший его метод класса UniLibrary
            throw  e; // в этом случае пробросится исключение дальше
        }
        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку " + "успешно вернули книгу ");
        System.out.println("Метод aroundReturnBookLoggingAdvice выполнил работу за: " + (end-begin) + " мс");
        return targetMethodResult;
    }

}
