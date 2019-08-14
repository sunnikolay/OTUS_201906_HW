package ru.otus;

import ru.otus.annotation.Log;
import ru.otus.utility.Utility;

import java.lang.reflect.Method;
import java.util.List;

public class Demo {

    public static void main( String[] args ) throws ClassNotFoundException {
        Class<?>     clazz = Class.forName( "ru.otus.TestLoggingImpl" );
        List<Method> methods = Utility.findMethod( Log.class, clazz.getDeclaredMethods() );

        if ( methods.size() > 0 ) {
            TestLoggingInterface tClass = IoC.createClass( new TestLoggingImpl() );
            tClass.calculation( 8 );
        }
    }

}
