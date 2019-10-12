package ru.otus.atm;

import ru.otus.cash.Banknotes;
import ru.otus.cassette.Cassette;
import ru.otus.cassette.CassetteImpl;
import ru.otus.request.Request;

import java.util.*;

public class AtmImpl implements Atm {

    /**
     * Существующие кассеты
     */
    private Set<Cassette> cassettes;

    /**
     * Constructor AtmImpl
     */
    public AtmImpl() {
        this.cassettes = new TreeSet<>( Comparator.comparing( Cassette::getDenomination ).reversed() );

        for ( Banknotes value : Banknotes.values() ) {
            Cassette someCassette = new CassetteImpl( value.getDenomination() );
            cassettes.add( someCassette );
        }

        initialize();
    }

    @Override
    public void initialize() {
        System.out.println( "Зарегистрированно кассет: " + cassettes.size() );
    }

    @Override
    public void banknotesIn( int[] banknotes ) {
        for ( int banknote : banknotes ) {
            for ( Cassette cassette : cassettes ) {
                if ( cassette.getDenomination() == banknote ) {
                    cassette.addCountDenomination();
                    break;
                }
            }
        }
        showCassetes();
    }

    @Override
    public List<Banknotes> banknotesOut( Request requestMoney ) {
        List<Banknotes> returnNotes = new ArrayList<>();
        int             remSum      = requestMoney.getRequestCash();
        List<Integer>   virtMoney   = new ArrayList<>();

        for ( Cassette cassette : this.cassettes ) {
            int denomination = cassette.getDenomination();
            int cntDenomination = cassette.getCountDenomination();
            if ( cntDenomination > 0 && remSum >= denomination && (remSum / denomination) <= cntDenomination ) {
                int countNotes = remSum / denomination;
                remSum = remSum % denomination;

                for ( int i = 0; i < countNotes; i++ ) {
                    cassette.subCountDenomination();
                    returnNotes.add( Banknotes.valueOf( "RUB_" + denomination ) );
                    virtMoney.add( denomination );
                }
            }
        }

        if ( remSum != 0 ) {
            for ( Integer integer : virtMoney ) {
                for ( Cassette cassette : cassettes ) {
                    if ( cassette.getDenomination() == integer ) {
                        cassette.addCountDenomination();
                        break;
                    }
                }
            }
            System.out.println( "Невозможно выдать сумму: " + requestMoney.getRequestCash() );
            returnNotes = new ArrayList<>();
        }

        return returnNotes;
    }

    /**
     * Печать кассет и кол-во банкнот в кассете
     */
    public void showCassetes() {
        for ( Cassette cassette : this.cassettes ) {
            System.out.println( cassette.getDenomination() + ": " + cassette.getCountDenomination() );
        }
        System.out.println( "--------------------------------------------------------------" );
    }

}
