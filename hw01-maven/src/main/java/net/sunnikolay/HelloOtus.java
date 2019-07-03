package net.sunnikolay;

import com.google.common.base.Splitter;

public class HelloOtus {

    public static void main( String[] args ) {
        String string = "abc, bcd,, cde   ,zsa";
        Object object = Splitter.on( ',' ).trimResults().omitEmptyStrings().split( string );
        System.out.println( object.toString() );
    }

}
