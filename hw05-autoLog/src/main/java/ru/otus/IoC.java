package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class IoC {

    static TestLoggingInterface createClass() {
        InvocationHandler invocationHandler = new TestLoggingInvocationHandler( new TestLoggingImpl() );

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
            System.out.println( "executed method: " + method + ", param: " + objects[0] );

            return method.invoke( objIntf, objects );
        }

        @Override
        public String toString() {
            return "TestLoggingInvocationHandler{class=" + objIntf + "}";
        }

    }

}
