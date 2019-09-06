package ru.otus.homework.utility;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class UtilityTests {

    private UtilityTests(){}

    public static List<Method> findMethod( Class<?> findClass, Method[] methods ) {
        List<Method> ms = new ArrayList<>();

        for ( Method method : methods ) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for ( Annotation annotation : annotations ) {
                if ( annotation.annotationType().equals( findClass ) ) {
                    ms.add( method );
                }
            }
        }

        return ms;
    }

}
