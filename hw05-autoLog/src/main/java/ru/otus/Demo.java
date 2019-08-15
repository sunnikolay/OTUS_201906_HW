package ru.otus;

import ru.otus.annotation.Log;
import ru.otus.utility.Utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Demo {

    public static void main( String[] args ) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?>     clazz   = Class.forName( "ru.otus.TestLoggingImpl" );
        List<Method> methods = Utility.findMethod( Log.class, clazz.getDeclaredMethods() );

        for ( Method method : methods ) {
            TestLoggingInterface tClass = IoC.createClass();
            for ( Method declaredMethod : tClass.getClass().getDeclaredMethods() ) {
                if ( method.getName().equals( declaredMethod.getName() ) ) {
                    int r = (int) (Math.random() * (100 + 8 - 1)) + 1;
                    declaredMethod.invoke( tClass, r );
                }
            }
        }
    }

}
