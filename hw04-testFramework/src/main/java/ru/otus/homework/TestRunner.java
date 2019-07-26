package ru.otus.homework;

import ru.otus.homework.annotation.After;
import ru.otus.homework.annotation.Before;
import ru.otus.homework.annotation.Test;
import ru.otus.homework.utility.UtilityTests;

import java.lang.reflect.*;
import java.util.List;

class TestRunner {

    private Class<?> aClass;

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
        methodsBefore = UtilityTests.findMethod( Before.class, clazz.getDeclaredMethods() );
        methodsTest   = UtilityTests.findMethod( Test.class, clazz.getDeclaredMethods() );
        methodsAfter  = UtilityTests.findMethod( After.class, clazz.getDeclaredMethods() );
    }

    /**
     * instance
     *
     * @return Object
     */
    private Object createInstance() {
        Object instance = null;

        try {
            instance = aClass.getDeclaredConstructors()[ 0 ].newInstance();
        }
        catch ( InstantiationException | IllegalAccessException | InvocationTargetException e ) {
            e.printStackTrace();
        }

        return instance;
    }

    /**
     * Запуск тестирования
     */
    private void startTest() {
        int     success = 0;
        int     error   = 0;

        for ( Method method : methodsTest ) {
            Object instance = createInstance();

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
     * Печать результатов тестирования
     */
    private void printResult( int success, int error ) {
        System.out.println( "---------------------------------------------" );
        System.out.println( "Всего зарегистрированно тестов: " + methodsTest.size() );
        System.out.println( "Успешно: " + success );
        System.out.println( "Не успешно: " + error );
    }

}
