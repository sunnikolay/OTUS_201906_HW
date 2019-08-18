package ru.otus;

public class Demo {

    public static void main( String[] args ) {
       // TestLoggingInterface tClass = IoC.createClass( new TestLoggingImpl() );
        MoreLoggingInterface mClass = IoC.createClass( new MoreLoggingImpl() );

//        tClass.calculation( (int) (Math.random() * (100 + 8 - 1)) + 1 );
//        tClass.calculationWithoutLog( (int) (Math.random() * (100 + 8 - 1)) + 1 );

        mClass.calculation( (int) (Math.random() * (100 + 8 - 1)) + 1 );
        mClass.calculation( (int) (Math.random() * (100 + 8 - 1)) + 1, "parameter 2" );
        mClass.calculationWithoutLog( (int) (Math.random() * (100 + 8 - 1)) + 1 );
    }

}
