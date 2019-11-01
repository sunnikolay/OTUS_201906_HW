package ru.otus.atm;

import ru.otus.atm.observer.Observer;
import ru.otus.cash.Banknotes;
import ru.otus.cassette.Cassette;
import ru.otus.cassette.CassetteImpl;
import ru.otus.department.Subject;
import ru.otus.request.Request;

import java.util.*;

public class AtmImpl implements Atm, Observer {

    /**
     * Имя банкомата
     */
    private String name;

    private int cashBalance;

    /**
     * Существующие кассеты в банкомате
     */
    private List<Cassette> cassettes;

    /**
     * Хранитель
     */
    private AtmKeeper keeper;

    /**
     * Constructor AtmImpl
     */
    public AtmImpl( String name, Subject department ) {
        this.name       = name;
        this.keeper     = new AtmKeeper();
        this.cassettes = new ArrayList<>();

        // Регистрация наблюдателя в Department
        department.registerObserver( this );

        for ( Banknotes value : Banknotes.values() ) {
            Cassette someCassette = new CassetteImpl( value.getDenomination() );
            cassettes.add( someCassette );
        }

        initialize();
    }

    @Override
    public void initialize() {
        compareReverse();
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
    }

    @Override
    public void banknotesIn( int[] banknotes, boolean save ) {
        for ( int banknote : banknotes ) {
            for ( Cassette cassette : cassettes ) {
                if ( cassette.getDenomination() == banknote ) {
                    cassette.addCountDenomination();
                    break;
                }
            }
        }

        // Сохранить состояние кассет
        if ( save ) { this.keeper.setSave( this.saveCassettes() ); }
    }

    @Override
    public List<Banknotes> banknotesOut( Request requestMoney ) {
        List<Banknotes> returnNotes = new ArrayList<>();
        int             remSum      = requestMoney.getRequestCash();
        List<Integer>   virtMoney   = new ArrayList<>();

        for ( Cassette cassette : this.cassettes ) {
            int denomination    = cassette.getDenomination();
            int cntDenomination = cassette.getCountDenomination();
            if ( cntDenomination > 0 && remSum >= denomination && ( remSum / denomination ) <= cntDenomination ) {
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
     * Сортировка массива от большего к меньшему
     */
    private void compareReverse() {
        this.cassettes.sort( CassetteImpl.COMPARE_REVERSE );
    }

    /**
     * Getter name
     *
     * @return Название банкомата
     */
    public String getName() {
        return name;
    }

    @Override
    public DefaultStateAtm saveCassettes() {
        return new DefaultStateAtm( this.cassettes );
    }

    @Override
    public void restoreCassettes() {
        this.cassettes.clear();
        for ( Cassette keeperCassette : this.keeper.getDefaultState().getCassettes() ) {
            Cassette nc = new CassetteImpl( keeperCassette.getDenomination() );
            nc.setCountDenomination( keeperCassette.getCountDenomination() );
            this.cassettes.add( nc );
        }
    }

    @Override
    public String toStringCassettes() {
        StringBuilder out = new StringBuilder( this.name + " -> {" );
        for ( Cassette cassette : this.cassettes ) {
            out.append( cassette.getDenomination() ).append( ":" ).append( cassette.getCountDenomination() ).append( "," );
        }
        out.delete( out.length() - 1, out.length() );
        out.append( "}" );

        return out.toString();
    }

    @Override
    public String getCashBalance() {
        StringBuilder out     = new StringBuilder( this.name + " balance: " );
        int           balance = 0;
        for ( Cassette cassette : this.cassettes ) {
            balance += cassette.getDenomination() * cassette.getCountDenomination();
        }
        out.append( balance );

        return String.valueOf( out );
    }

    @Override
    public void printCashBalance() {
        System.out.println( this.getCashBalance() );
    }

}
