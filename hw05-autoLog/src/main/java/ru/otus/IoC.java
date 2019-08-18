package ru.otus;

import ru.otus.annotation.Log;
import ru.otus.models.MethodModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class IoC {

    static <T> T createClass( Object testObj ) {
        Class<?>          classInterface    = null;
        InvocationHandler invocationHandler = new MyInvocationHandler( testObj );
        Set<String> interfaceses = new HashSet<>(
                Arrays.asList( "ru.otus.TestLoggingInterface", "ru.otus.MoreLoggingInterface" )
        );

        for ( Type genericInterface : testObj.getClass().getGenericInterfaces() ) {
            if ( interfaceses.contains( genericInterface.getTypeName() ) ) {
                classInterface = (Class<?>) genericInterface;
            }
        }

        return (T) Proxy.newProxyInstance(
                IoC.class.getClassLoader(),
                new Class<?>[]{ classInterface },
                invocationHandler
        );
    }

    static class MyInvocationHandler implements InvocationHandler {

        private final Object objIntf;

        private Set<MethodModel> methodModels = new HashSet<>();

        MyInvocationHandler( Object testLogging ) {
            this.objIntf = testLogging;

            initialize();
        }

        private void initialize() {
            for ( Method declaredMethod : objIntf.getClass().getDeclaredMethods() ) {
                for ( Annotation declaredAnnotation : declaredMethod.getDeclaredAnnotations() ) {
                    if ( declaredAnnotation.annotationType().equals( Log.class ) ) {
                        MethodModel mm = new MethodModel( declaredMethod.getName(), declaredMethod.getParameters() );
                        methodModels.add( mm );
                    }
                }
            }
        }

        @Override
        public Object invoke( Object o, Method method, Object[] objects ) throws Throwable {
            MethodModel newMM = new MethodModel( method.getName(), method.getParameters() );

            for ( MethodModel methodModel : methodModels ) {
                System.out.println( "set model name: " + methodModel.getName() );
                System.out.println( "set model parameters: " + Arrays.toString( methodModel.getParameters() ) );
                System.out.println( "new object name: " + newMM.getName() );
                System.out.println( "new object parameters: " + Arrays.toString( newMM.getParameters() ) );
                System.out.println( "equals name: " + methodModel.getName().equals( newMM.getName() ) );
                System.out.println( "equals parameters: " + Arrays.equals( newMM.getParameters(), methodModel.getParameters() ) );
                System.out.println( "------------------------------------------------" );
//                if ( methodModel.getName().equals( newMM.getName() ) && Arrays.equals( methodModel.getParameters(), newMM.getParameters() ) ) {
//                    System.out.println( "executed method: " + method + ", param: " + Arrays.toString( objects ) );
//                }
            }

            return method.invoke( objIntf, objects );
        }

        @Override
        public String toString() {
            return "MyInvocationHandler{class=" + objIntf + "}";
        }

    }

}
