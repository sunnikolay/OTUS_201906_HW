package ru.otus.cassette;

public class SomeCassette extends Cassette {

    /**
     * Constructor
     *
     * @param denomination номинал купюры
     */
    public SomeCassette( int denomination ) {
        super( denomination );
    }

    @Override
    public int getCountDenomination() {
        return this.countDenomination;
    }

}
