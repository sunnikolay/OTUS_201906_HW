package ru.otus.cassette;

public abstract class Cassette {

    /**
     * Номинал купюры
     */
    private int denomination;

    /**
     * Количество купюр в ячейке
     */
    int countDenomination = 0;

    /**
     * Constructor
     *
     * @param denomination номинал купюры
     */
    Cassette( int denomination ) {
        this.denomination = denomination;
    }

    /**
     * Добавить количество купюр
     */
    public void addCountDenomination() {
        this.countDenomination++;
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
     * Запросить количество купюр в кассете.
     */
    public abstract int getCountDenomination();

}
