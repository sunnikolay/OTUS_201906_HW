package ru.otus.homework.calc;

import ru.otus.homework.annotation.After;
import ru.otus.homework.annotation.Before;
import ru.otus.homework.annotation.Test;

public class CalculatorTest {

    //@Before
    public void startTwo() throws Exception {
        throw new Exception( "new Exception..." );

    }

    @Before
    public void start() throws Exception {
        System.out.println("start test...");
    }

    @Test()
    public void add() {
        int x = 5;
        int y = 5;
        int resultTest = x + y;
        int resultMethod = new Calculator().add( x, y );
        System.out.println( "Result method add: " + ( resultTest == resultMethod ) );
    }

    @Test()
    public void sub() {
        int x = 5;
        int y = 5;
        int resultTest = x + y;
        int resultMethod = new Calculator().sub( x, y );
        System.out.println( "Result method sub: " + ( resultTest == resultMethod ) );
    }

    @Test()
    public void err() throws Exception {
        new Calculator().err();
    }

    @After
    public void end() {
        System.out.println( "end test..." );
    }

}
