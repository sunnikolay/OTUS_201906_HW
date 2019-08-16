package ru.otus;

import ru.otus.annotation.Log;
import ru.otus.utility.Utility;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class IoC {

    static TestLoggingInterface createClass( TestLoggingImpl testObj ) {
        InvocationHandler invocationHandler = new TestLoggingInvocationHandler( testObj );

        return (TestLoggingInterface) Proxy.newProxyInstance(
                IoC.class.getClassLoader(),
                new Class<?>[]{ TestLoggingInterface.class },
                invocationHandler
        );
    }

    static class TestLoggingInvocationHandler implements InvocationHandler {

        private final Object objIntf;

        public TestLoggingInvocationHandler( TestLoggingImpl testLogging ) {
            this.objIntf = testLogging;
        }

        @Override
        public Object invoke( Object o, Method method, Object[] objects ) throws Throwable {
            if ( Utility.checkAnnotation( Log.class, method ) ) {
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
