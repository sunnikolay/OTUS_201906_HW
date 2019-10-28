package ru.otus.atm;

import ru.otus.cassette.Cassette;
import ru.otus.cassette.CassetteImpl;

import java.util.ArrayList;
import java.util.List;

class DefaultStateAtm {

    private final List<Cassette> copy;

    DefaultStateAtm( List<Cassette> cassettes ) {
        this.copy = new ArrayList<>();

        for ( Cassette cassette : cassettes ) {
            Cassette c = new CassetteImpl( cassette.getDenomination() );
            c.setCountDenomination( cassette.getCountDenomination() );
            copy.add( c );
        }
    }

    List<Cassette> getCassettes() {
        return this.copy;
    }

}
