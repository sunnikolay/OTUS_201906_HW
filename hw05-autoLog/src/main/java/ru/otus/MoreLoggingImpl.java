package ru.otus;

import ru.otus.annotation.Log;

public class MoreLoggingImpl implements MoreLoggingInterface {

    @Log
    @Override
    public void calculation( int param ) {}

    @Override
    public void calculation( int param, String param2 ) {}

    @Override
    public void calculationWithoutLog( int param ) {}

}
