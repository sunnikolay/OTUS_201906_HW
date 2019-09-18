package ru.otus;

import ru.otus.output.Money;
import ru.otus.slot.Banknote;
import ru.otus.slot.MoneySlot;

public class Atm {

    public static void main( String[] args ) {

        int requestMoney = 10800;

        MoneySlot slot5000 = new MoneySlot( Banknote.RUB_5000 );
        MoneySlot slot1000 = new MoneySlot( Banknote.RUB_1000 );
        MoneySlot slot500 = new MoneySlot( Banknote.RUB_500 );
        MoneySlot slot200 = new MoneySlot( Banknote.RUB_200 );
        MoneySlot slot100 = new MoneySlot( Banknote.RUB_100 );

        slot5000.setMoneySlotNext( slot1000 );
        slot1000.setMoneySlotNext( slot500 );
        slot500.setMoneySlotNext( slot200 );
        slot200.setMoneySlotNext( slot100 );

        slot5000.givingCash( new Money( requestMoney ) );

    }

}
