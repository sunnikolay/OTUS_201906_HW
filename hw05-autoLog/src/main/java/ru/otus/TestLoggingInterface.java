package ru.otus;

import ru.otus.annotation.Log;

public interface TestLoggingInterface {
    @Log
    void calculation( int param );

    void calculationWithoutLog( int param );

}
