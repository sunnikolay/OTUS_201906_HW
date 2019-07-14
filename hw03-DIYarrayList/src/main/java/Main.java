import model.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main( String[] args ) {
        DIYArrayList<Animal> animals = new DIYArrayList<>();
        animals.add( new Animal() );
        animals.add( new Animal() );
        animals.add( new Animal() );

        DIYArrayList<Cat> cats = new DIYArrayList<>();
        for ( int i = 0; i < 20; i++ ) {
            cats.add( new Cat() );
        }

        DIYArrayList<HomeCat> homeCats = new DIYArrayList<>();
        for ( int j = 0; j < 9; j++ ) {
            homeCats.add( new HomeCat( "cat #" + ( j + 1 ) ) );
        }

//        boolean b = Collections.addAll( cats, new HomeCat( "cat #4" ) );
//        System.out.println( "-------------------------------------" );
//        System.out.println( "Size cats after addAll: " + cats.size() );
//        System.out.println( cats.toString() );
//        System.out.println( "-------------------------------------" );

        System.out.println( "PRINT cats(before): " + cats.toString() );
        Collections.copy( cats, homeCats );
//        System.out.println( "Size cats after copy: " + cats.size() );
        System.out.println( "PRINT cats(after): " + cats.toString() );
    }

}
