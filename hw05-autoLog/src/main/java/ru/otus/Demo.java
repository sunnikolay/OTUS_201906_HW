package ru.otus;

public class Demo {

    public static void main( String[] args ) {
        TestLoggingInterface tClass = IoC.createClass( new TestLoggingImpl() );
        tClass.calculation( (int) (Math.random() * (100 + 8 - 1)) + 1 );
        tClass.calculationWithoutLog( (int) (Math.random() * (100 + 8 - 1)) + 1 );
    }

}
