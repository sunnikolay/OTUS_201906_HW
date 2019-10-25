package ru.otus.atm;

import ru.otus.cash.Banknotes;
import ru.otus.request.Request;

import java.util.List;

public interface Atm {

    void initialize();

    void banknotesIn( int[] banknotes );

    void banknotesIn( int[] banknotes, boolean save );

    void showCassetes();

    List<Banknotes> banknotesOut( Request requestMoney );

    String getName();

    Memento saveCasettes();

}
