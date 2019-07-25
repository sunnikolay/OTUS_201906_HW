import annotation.After;
import annotation.Before;
import annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

class TestRunner {

    private Class<?> aClass;

    private Method[]     allMethods;
    private List<Method> methodsBefore;
    private List<Method> methodsTest;
    private List<Method> methodsAfter;

    /**
     * Конструктор
     */
    TestRunner( Class<?> clazz ) {
        aClass = clazz;
        initialize( aClass );
        startTest();
    }

    /**
     * Инициализация
     */
    private void initialize( Class<?> clazz ) {
        allMethods = clazz.getDeclaredMethods();

        methodsBefore = findMethod( Before.class );
        methodsTest   = findMethod( Test.class );
        methodsAfter  = findMethod( After.class );
    }

    /**
     * Запуск тестирования
     */
    private void startTest() {
        Object instance = null;
        int     success = 0;
        int     error   = 0;

        for ( Method method : methodsTest ) {
            try {
                instance = aClass.getDeclaredConstructors()[ 0 ].newInstance();
            }
            catch ( InstantiationException | IllegalAccessException | InvocationTargetException e ) {
                e.printStackTrace();
            }

            // @Before
            if ( startMethods( methodsBefore, instance ) ) {
                // @Test
                if ( startMethod( method, instance ) ) { success++; }
                else { error++; }
            }

            // @After
            startMethods( methodsAfter, instance );
        }

        printResult( success, error );
    }

    /**
     * invoke метода
     */
    private boolean startMethod( Method method, Object instance ) {
        try {
            method.invoke( instance );
            return true;
        }
        catch ( IllegalAccessException | InvocationTargetException e ) {
            return false;
        }
    }

    /**
     * invoke методов, результат выполнения не затрагивает счетчики
     */
    private boolean startMethods( List<Method> methods, Object instance ) {
        boolean result = true;

        for ( Method method : methods ) {
            try {
                method.invoke( instance );
            }
            catch ( IllegalAccessException | InvocationTargetException e ) {
                e.printStackTrace();
                result = false;
            }
        }

        return result;
    }

    /**
     * Поиск метода по аннотации
     *
     * @param findClass Аннотация
     *
     * @return Methods
     */
    private List<Method> findMethod( Class<?> findClass ) {
        List<Method> ms = new ArrayList<>();

        for ( Method method : allMethods ) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for ( Annotation annotation : annotations ) {
                if ( annotation.annotationType().equals( findClass ) ) {
                    ms.add( method );
                }
            }
        }

        return ms;
    }

    /**
     * Печать результатов тестирования
     */
    private void printResult( int success, int error ) {
        System.out.println( "---------------------------------------------" );
        System.out.println( "Всего зарегистрированно тестов: " + methodsTest.size() );
        System.out.println( "Успешно: " + success );
        System.out.println( "Не успешно: " + error );
    }

}
