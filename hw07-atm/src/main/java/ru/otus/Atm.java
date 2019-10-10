package ru.otus;

import ru.otus.cash.Banknotes;
import ru.otus.cash.Cash;
import ru.otus.cassette.*;

import java.util.ArrayList;
import java.util.List;

public class Atm {

    private static List<Cassette> cassettes = new ArrayList<>();

    public static void main( String[] args ) {
        initialize( 10 );
        int requestMoney = 10800;

        // Выдача денег
        output( requestMoney );
    }

    /**
     * Создаем кассеты и загружаем в каждую кассету купюры требующего номинала
     *
     * @param count количество купюр в каждую кассету
     */
    private static void initialize( int count ) {
        for ( Banknotes value : Banknotes.values() ) {
            Cassette someCassette = new SomeCassette( value.getDenomination() );
            for ( int i = 0; i < count; i++ ) {
                someCassette.addCountDenomination();
            }
            cassettes.add( someCassette );
        }
    }

    /**
     * Выдать запрашиваемую сумму
     *
     * @param money сумма денег
     */
    private static void output( int money ) {
        System.out.println( "ВЫДАЧА КУПЮР" );
        Cash cash = new Cash( cassettes, money );
        System.out.println( cash.requestMoney );
    }

}
