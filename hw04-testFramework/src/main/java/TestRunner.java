import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;

public class Ananalize {

    private Class<?> aClass;

    private ArrayList<String> methodNames = new ArrayList<>();

    private ArrayList<Method> methodTests;

    private Object instance;

    private Method[] methods;

    private int testOk = 0;

    private int testErr = 0;

    private int count = 0;

    /**
     * Конструктор
     */
    Ananalize( Class<?> clazz ) {

        this.aClass = clazz;

        // Инициализация первого запуска
        initialize( this.aClass );

        this.count = this.methodNames.size();

        // Старт
        startTest();

    }

    /**
     * Инициализация
     */
    private void initialize( Class<?> clazz ) {
        try {
            this.instance = clazz.getDeclaredConstructors()[ 0 ].newInstance();
        }
        catch ( InstantiationException | IllegalAccessException | InvocationTargetException e ) {
            e.printStackTrace();
        }

        methods = clazz.getDeclaredMethods();

        methodTests = findMethod( "@annotation.Test()" );
        for ( Method methodTest : methodTests ) {
            methodNames.add( methodTest.getName() );
        }
    }

    /**
     * Запуск тестирования
     */
    private void startTest() {
        for ( Method method : this.methodTests ) {
            if ( this.methodNames.contains( method.getName() ) ) {
                startMethod( "@annotation.Before()" );
                startMethod( method );
                System.out.println( "instance: " + this.instance );
                startMethod( "@annotation.After()" );

                clean( method );
            }
        }

        printResult();
    }

    /**
     * Очистка
     *
     * @param method
     */
    private void clean( Method method ) {
        methodNames.remove( method.getName() );

        this.methodTests = null;
        this.instance    = null;
        this.methods     = null;

        initialize( this.aClass );
    }

    /**
     * invoke метода
     *
     * @param anno Имя аннотации
     */
    private void startMethod( String anno ) {
        ArrayList<Method> methods = findMethod( anno );

        if ( methods.size() > 0 ) {
            try {
                for ( Method method : methods ) {
                    method.invoke( this.instance );
                }
            }
            catch ( IllegalAccessException | InvocationTargetException e ) {
                e.printStackTrace();
            }
        }
    }

    /**
     * invoke метода
     */
    private void startMethod( Method method ) {
        try {
            method.invoke( this.instance );
            this.testOk++;
        }
        catch ( IllegalAccessException | InvocationTargetException e ) {
            this.testErr++;
            e.printStackTrace();
        }
    }

    /**
     * Поиск метода по аннотации
     *
     * @param findAnn Аннотация
     *
     * @return Methods
     */
    private ArrayList<Method> findMethod( String findAnn ) {
        ArrayList<Method> ms = new ArrayList<>();

        for ( Method method : this.methods ) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for ( Annotation annotation : annotations ) {
                if ( annotation.toString().equals( findAnn ) ) {
                    ms.add( method );
                }
            }
        }

        return ms;
    }

    /**
     * Печать результатов тестирования
     */
    private void printResult() {
        System.out.println( "---------------------------------------------" );
        System.out.println( "Всего зарегистрированно тестов: " + this.count );
        System.out.println( "Успешно: " + this.testOk );
        System.out.println( "Не успешно: " + this.testErr );
    }

}
