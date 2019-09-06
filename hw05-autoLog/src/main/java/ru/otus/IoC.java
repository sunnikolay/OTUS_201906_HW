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

    static <T> T createClass( Object testObj ) {
        InvocationHandler invocationHandler = new MyInvocationHandler( testObj );

        return (T) Proxy.newProxyInstance(
                IoC.class.getClassLoader(),
                testObj.getClass().getInterfaces(),
                invocationHandler
        );
    }

    static class MyInvocationHandler implements InvocationHandler {

        private final Object objIntf;

        private Set<String> methodModels = new HashSet<>();

        MyInvocationHandler( Object testLogging ) {
            this.objIntf = testLogging;

            initialize();
        }

        private void initialize() {
            for ( Method declaredMethod : objIntf.getClass().getDeclaredMethods() ) {
                for ( Annotation declaredAnnotation : declaredMethod.getDeclaredAnnotations() ) {
                    if ( declaredAnnotation.annotationType().equals( Log.class ) ) {
                        methodModels.add( declaredMethod.getName() + Arrays.toString( declaredMethod.getParameters() ) );
                    }
                }
            }
        }

        @Override
        public Object invoke( Object o, Method method, Object[] objects ) throws Throwable {
                String customKey = method.getName() + Arrays.toString( method.getParameters() );

                if ( methodModels.contains( customKey ) ) {
                    System.out.println( "executed method: " + method + ", param: " + Arrays.toString( objects ) );
                }


            return method.invoke( objIntf, objects );
        }

        @Override
        public String toString() {
            return "MyInvocationHandler{class=" + objIntf + "}";
        }

    }

}
