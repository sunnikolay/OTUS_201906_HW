package ru.otus.atm;

public class AtmKeeper {

    private DefaultStateAtm defaultState;

    DefaultStateAtm getDefaultState() {
        return this.defaultState;
    }

    void setSave( DefaultStateAtm defaultState ) {
        this.defaultState = defaultState;
    }

}
