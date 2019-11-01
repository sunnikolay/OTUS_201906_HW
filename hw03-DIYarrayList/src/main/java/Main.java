import model.*;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main( String[] args ) {
        System.out.println( "******************** ADD ALL ***********************************" );
        DIYArrayList<Animal> diyAnimals1 = new DIYArrayList<>();
        DIYArrayList<Animal> diyAnimals2 = new DIYArrayList<>();
        for ( int i = 0; i < 20; i++ ) {
            diyAnimals1.add( new Dog() );
        }
        diyAnimals2.addAll( diyAnimals1 );
        int cnt = 1;
        for ( Animal animal : diyAnimals2 ) {
//            System.out.println( cnt + " -> " + animal.toString() );
//            cnt++;
        }
        System.out.println( "******************** COPY **************************************" );
        DIYArrayList<Cat>     dest = new DIYArrayList<>();
        DIYArrayList<HomeCat> src  = new DIYArrayList<>();
        for ( int i = 0; i < 20; i++ ) {
            dest.add( new Cat() );
        }
        cnt = 1;
        for ( int i = 0; i < 20; i++ ) {
            src.add( new HomeCat( "Barsik " + cnt ) );
            cnt++;
        }
        Collections.copy( dest, src );
        cnt = 1;
        for ( Cat cat : dest ) {
            System.out.println( cnt + " -> " + cat.toString() );
            cnt++;
        }


//        DIYArrayList<Cat> cats = new DIYArrayList<>();
//        for ( int i = 0; i < 20; i++ ) {
//            cats.add( new Cat() );
//        }
//
//        DIYArrayList<HomeCat> homeCats = new DIYArrayList<>();
//        for ( int j = 0; j < 9; j++ ) {
//            homeCats.add( new HomeCat( "cat #" + ( j + 1 ) ) );
//        }

//        boolean b = Collections.addAll( cats, new HomeCat( "cat #4" ) );
//        System.out.println( "-------------------------------------" );
//        System.out.println( "Size cats after addAll: " + cats.size() );
//        System.out.println( cats.toString() );
//        System.out.println( "-------------------------------------" );

//        System.out.println( "PRINT cats(before): " + cats.toString() );
//        Collections.copy( cats, homeCats );
//        System.out.println( "Size cats after copy: " + cats.size() );
//        System.out.println( "PRINT cats(after): " + cats.toString() );
    }

}
