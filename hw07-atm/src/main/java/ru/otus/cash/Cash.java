package ru.otus.cash;

import ru.otus.cassette.Cassette;

import java.util.List;

public class Cash {

    public int requestMoney;

    private List<Cassette> cassettes;

    public Cash( List<Cassette> cassettes, int requestMoney ) {
        this.cassettes = cassettes;
        this.requestMoney = requestMoney;
    }

}
