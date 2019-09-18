package ru.otus;

import ru.otus.output.Money;
import ru.otus.slot.Banknote;
import ru.otus.slot.MoneySlot;

import java.util.Arrays;

public class Atm {

    private static MoneySlot slot5000 = new MoneySlot( Banknote.RUB_5000 );
    private static MoneySlot slot1000 = new MoneySlot( Banknote.RUB_1000 );
    private static MoneySlot slot500  = new MoneySlot( Banknote.RUB_500 );
    private static MoneySlot slot200  = new MoneySlot( Banknote.RUB_200 );
    private static MoneySlot slot100  = new MoneySlot( Banknote.RUB_100 );

    public static void main( String[] args ) {
        int   requestMoney = 10800;
        int[] inputMoney   = { 100, 100, 100, 200, 200, 500, 1000, 1000, 1000, 1000, 5000 };

        initialize();

        // Ввод денег
        input( inputMoney );

        // Выдача денег
        output( requestMoney );
    }

    private static void initialize() {
        slot5000.setMoneySlotNext( slot1000 );
        slot1000.setMoneySlotNext( slot500 );
        slot500.setMoneySlotNext( slot200 );
        slot200.setMoneySlotNext( slot100 );
    }

    // TODO надо подумать на счет паттерна "visitor"
    private static void input( int[] money ) {
        System.out.println( "ВВОД КУПЮР" );
        int sum = 0;
        for ( int value : money ) {
            slot5000.inputCash( new Money( value ) );
            sum = value + sum;
        }
        System.out.println( "Сумма купюр: " + sum + " " + Arrays.toString( money ) );
        System.out.println( "СЛОТ 5000: " + slot5000.getCountDenomination() );
        System.out.println( "СЛОТ 1000: " + slot1000.getCountDenomination() );
        System.out.println( "СЛОТ 500:  " + slot500.getCountDenomination() );
        System.out.println( "СЛОТ 200:  " + slot200.getCountDenomination() );
        System.out.println( "СЛОТ 100:  " + slot100.getCountDenomination() );
        System.out.println( "---------------------------------------------------------" );
    }

    /**
     * Выдать запрашиваемую сумму
     *
     * @param money сумма денег
     */
    private static void output( int money ) {
        System.out.println( "ВЫДАЧА КУПЮР" );
        slot5000.givingCash( new Money( money ) );
        System.out.println( "---------------------------------------------------------" );
    }

}
