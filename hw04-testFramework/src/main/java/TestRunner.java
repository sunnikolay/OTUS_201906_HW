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
    private List<Method> finishedMethods = new ArrayList<>();

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

        methodsBefore = findMethod( "@annotation.Before()" );
        methodsTest   = findMethod( "@annotation.Test()" );
        methodsAfter  = findMethod( "@annotation.After()" );
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

            if ( ! finishedMethods.contains( method ) ) {
                // @Before
                startMethods( methodsBefore, instance );

                // @Test
                if ( startMethod( method, instance ) ) { success++; }
                else { error++; }

                // @After
                startMethods( methodsAfter, instance );

                // Добавить текущий метод в список выполненых
                finishedMethods.add( method );
            }
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
    private void startMethods( List<Method> methods, Object instance ) {
        for ( Method method : methods ) {
            try {
                method.invoke( instance );
            }
            catch ( IllegalAccessException | InvocationTargetException e ) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Поиск метода по аннотации
     *
     * @param findAnn Аннотация
     *
     * @return Methods
     */
    private List<Method> findMethod( String findAnn ) {
        List<Method> ms = new ArrayList<>();

        for ( Method method : allMethods ) {
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
    private void printResult( int success, int error ) {
        System.out.println( "---------------------------------------------" );
        System.out.println( "Всего зарегистрированно тестов: " + finishedMethods.size() );
        System.out.println( "Успешно: " + success );
        System.out.println( "Не успешно: " + error );
    }

}
