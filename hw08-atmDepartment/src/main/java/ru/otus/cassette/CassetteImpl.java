package ru.otus.cassette;

public class CassetteImpl implements Cassette {

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

    @Override
    public int getCountDenomination() {
        return this.countDenomination;
    }

}
