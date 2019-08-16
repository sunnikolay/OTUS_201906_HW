package ru.otus;

import ru.otus.annotation.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class IoC {

    static TestLoggingInterface createClass( Object testObj ) {
        InvocationHandler invocationHandler = new TestLoggingInvocationHandler( testObj );

        return (TestLoggingInterface) Proxy.newProxyInstance(
                IoC.class.getClassLoader(),
                new Class<?>[]{ TestLoggingInterface.class },
                invocationHandler
        );
    }

    static class TestLoggingInvocationHandler implements InvocationHandler {

        private final Object objIntf;

        private Set<String> methodModels = new HashSet<>();

        TestLoggingInvocationHandler( Object testLogging ) {
            this.objIntf = testLogging;

            initialize();
        }

        private void initialize() {
            for ( Method declaredMethod : objIntf.getClass().getDeclaredMethods() ) {
                for ( Annotation declaredAnnotation : declaredMethod.getDeclaredAnnotations() ) {
                    if ( declaredAnnotation.annotationType().equals( Log.class ) ) {
                        methodModels.add( declaredMethod.getName() );
                    }
                }
            }
        }

        @Override
        public Object invoke( Object o, Method method, Object[] objects ) throws Throwable {

            if ( methodModels.contains( String.valueOf( method.getName() ) ) ) {
                System.out.println( "executed method: " + method + ", param: " + Arrays.toString( objects ) );
            }

            return method.invoke( objIntf, objects );
        }

        @Override
        public String toString() {
            return "TestLoggingInvocationHandler{class=" + objIntf + "}";
        }

    }

}
