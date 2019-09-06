package ru.otus.homework;

public class Demo {

    public static void main( String[] args ) {
        try {
            new TestRunner( Class.forName( args[0] ) );
        }
        catch ( ClassNotFoundException e ) {
            System.out.println( "Класс \"" + args[0] + "\" не найден!!!" );
            System.out.println( e.getMessage() );
        }
        catch ( ArrayIndexOutOfBoundsException exception ) {
            System.out.println( "Аргумент не может быть пустым..." );
            System.out.println( exception.getMessage() );
        }
    }

}
