import model.*;

public class Main {

    public static void main( String[] args ) {
        DIYArrayList<Cat> cats = new DIYArrayList<>();
        cats.add( new Cat() );
        cats.add( new Cat() );
        cats.add( new Cat() );
//        System.out.println( "CATS index 1: " + cats.get( 1 ) );
        System.out.println( "CATS size: " + cats.size() );
//        System.out.println( "CATS isEmpty: " + cats.isEmpty() );

        DIYArrayList<HomeCat> homeCats = new DIYArrayList<>();
        homeCats.add( new HomeCat( "cat #1" ) );
        homeCats.add( new HomeCat( "cat #2" ) );
//        System.out.println( "HomeCATS index 1: " + homeCats.get( 1 ) );
        System.out.println( "HomeCATS size: " + homeCats.size() );
//        System.out.println( "HomeCATS isEmpty: " + homeCats.isEmpty() );

        homeCats.addAll( cats );
        System.out.println( "After addAll homeCats to cats size: " + homeCats.size() );
    }

}
