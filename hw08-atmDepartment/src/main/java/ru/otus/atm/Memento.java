package ru.otus.atm;

import ru.otus.cassette.Cassette;

import java.util.Set;

public class Memento {

    private final Set<Cassette> cassettes;

    Memento( Set<Cassette> cassettes ) {this.cassettes = cassettes;}

    public Set<Cassette> getCassettes() {
        return this.cassettes;
    }

}
