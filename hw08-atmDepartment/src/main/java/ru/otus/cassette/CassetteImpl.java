package ru.otus.cassette;

import java.io.Serializable;
import java.util.Comparator;

public class CassetteImpl implements Cassette, Serializable {

    /**
     * Номинал купюры
     */
    private final int denomination;

    /**
     * Количество купюр в ячейке
     */
    private int countDenomination = 0;

    /**
     * Constructor
     *
     * @param denomination номинал купюры
     */
    public CassetteImpl( int denomination ) {
        this.denomination = denomination;
    }

    @Override
    public void addCountDenomination() {
        this.countDenomination++;
    }

    @Override
    public boolean subCountDenomination() {
        if ( this.countDenomination > 0 ) {
            this.countDenomination--;
            return true;
        }
        else {
            return false;
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
     * @param countDenomination
     */
    public void setCountDenomination( int countDenomination ) {
        this.countDenomination = countDenomination;
    }

    @Override
    public int getCountDenomination() {
        return this.countDenomination;
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
