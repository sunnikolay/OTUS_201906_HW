import java.lang.reflect.InvocationTargetException;

public class Demo {

    private static Class<?> clazz;

    public static void main( String[] args ) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        try {
            clazz = Class.forName( args[0] );
            Ananalize ananalize = new Ananalize( clazz );
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
