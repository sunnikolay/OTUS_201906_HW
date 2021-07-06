package ru.otus.cassette;

import ru.otus.atm.observer.BalanceObserverCassette;
import ru.otus.cassette.subject.SubjectCassette;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CassetteImpl implements Cassette, Serializable, SubjectCassette {

    /**
     * Номинал купюры
     */
    private final int denomination;

    /**
     * Количество купюр в ячейке
     */
    private int countDenomination = 0;

    /**
     * Список наблюдателей
     */
    private List<BalanceObserverCassette> observers;

    /**
     * Constructor
     *
     * @param denomination номинал купюры
     */
    public CassetteImpl( int denomination ) {
        this.denomination = denomination;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addCountDenomination() {
        this.countDenomination++;
        this.notifyObservers();
    }

    @Override
    public boolean subCountDenomination() {
        if ( this.countDenomination > 0 ) {
            this.countDenomination--;
            this.notifyObservers();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getCountDenomination() {
        return this.countDenomination;
    }

    @Override
    public void registerObserver( BalanceObserverCassette observer ) {
        this.observers.add( observer );
    }

    @Override
    public void removeObserver( BalanceObserverCassette observer ) {
        this.observers.remove( observer );
    }

    @Override
    public void notifyObservers() {
        for ( BalanceObserverCassette observer : this.observers ) {
            observer.balanceChangeCassette();
        }
    }

    /**
     * Getter denomination
     *
     * @return denomination
     */
    public int getDenomination() {
        return this.denomination;
    }

    /**
     * Setter denomination
     *
     * @param countDenomination количество купюр
     */
    public void setCountDenomination( int countDenomination ) {
        this.countDenomination = countDenomination;
    }

    /**
     * Сортировка по номиналу от большего к меньшему
     */
    public static final Comparator<Cassette> COMPARE_REVERSE = new Comparator<Cassette>() {
        @Override
        public int compare( Cassette o1, Cassette o2 ) {
            return Integer.compare( o2.getDenomination(), o1.getDenomination() );
        }
    };

}
