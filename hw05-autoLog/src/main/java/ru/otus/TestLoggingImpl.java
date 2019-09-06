package ru.otus;

import ru.otus.annotation.Log;

public class TestLoggingImpl implements TestLoggingInterface {

    @Log
    public void calculation( int param ) {}

    public void calculationWithoutLog( int param ) {}

}
