package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IoC {

    static TestLoggingInterface createClass( TestLoggingImpl testLogging ) {
        InvocationHandler invocationHandler = new TestLoggingInvocationHandler( testLogging );

        return (TestLoggingInterface) Proxy.newProxyInstance(
                IoC.class.getClassLoader(),
                new Class<?>[]{ TestLoggingInterface.class },
                invocationHandler
        );
    }

    static class TestLoggingInvocationHandler implements InvocationHandler {

        private final TestLoggingInterface testLoggingInterface;

        public TestLoggingInvocationHandler( TestLoggingImpl testLogging ) {
            this.testLoggingInterface = testLogging;
        }

        @Override
        public Object invoke( Object o, Method method, Object[] objects ) throws Throwable {
            System.out.println( "executed method: " + method + ", param: " + objects[0] );

            return method.invoke( testLoggingInterface, objects );
        }

        @Override
        public String toString() {
            return "TestLoggingInvocationHandler{class=" + testLoggingInterface + "}";
        }

    }

}
