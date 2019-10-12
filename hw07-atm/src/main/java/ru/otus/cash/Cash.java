package ru.otus.cash;

import java.util.List;

public class Cash {

    private List<Banknotes> banknotes;

    public Cash( List<Banknotes> banknotes ) {
        this.banknotes = banknotes;
    }

    public List<Banknotes> getBanknotes() {
        return banknotes;
    }

}
