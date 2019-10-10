package ru.otus.cash;

public enum Banknotes {
    RUB_100(100), RUB_200(200), RUB_500(500), RUB_1000(1000),
    RUB_5000(5000);

    private int denomination;

    Banknotes( int denomination ) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
}
