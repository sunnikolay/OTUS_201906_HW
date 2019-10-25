package ru.otus;

import ru.otus.atm.Atm;
import ru.otus.atm.AtmImpl;
import ru.otus.cash.Cash;
import ru.otus.request.Request;

public class StartApp {

    public static void main( String[] args ) {
        Atm   atm     = new AtmImpl();
        int[] inNotes = {100,100,100,100,200,200,200,500,500,500,1000,1000,1000,1000,5000,5000,5000,5000};
        atm.banknotesIn( inNotes );

        // Запрос на выдачу денег
        Request r1 = new Request( 10800 );
        Request r2 = new Request( 7900 );
        Request r3 = new Request( 8000 );
        Request r4 = new Request( 7800 );

        Cash cash1 = new Cash( atm.banknotesOut( r1 ) );
        System.out.println( cash1.getBanknotes() );
        atm.showCassetes();

        Cash cash2 = new Cash( atm.banknotesOut( r2 ) );
        System.out.println( cash2.getBanknotes() );
        atm.showCassetes();

        Cash cash3 = new Cash( atm.banknotesOut( r3 ) );
        System.out.println( cash3.getBanknotes() );
        atm.showCassetes();

        Cash cash4 = new Cash( atm.banknotesOut( r4 ) );
        System.out.println( cash4.getBanknotes() );
        atm.showCassetes();
    }

}
