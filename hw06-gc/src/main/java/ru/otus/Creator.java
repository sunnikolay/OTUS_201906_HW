package ru.otus;

import java.util.ArrayList;
import java.util.List;

public class Creator {

    public static void main( String[] args ) throws InterruptedException {
        startCreateObjects();

        System.out.println( "done" );
    }

    private static void startCreateObjects() throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        for ( int i = 0; i < Integer.MAX_VALUE; i++ ) {
            Integer obj = i;

            for ( int j = 0; j < 1; j++ ) {
                list.add( obj );
            }

            if ( i % 1000 == 0 ) {
                Thread.sleep( 1 );
            }

        }
    }

}
