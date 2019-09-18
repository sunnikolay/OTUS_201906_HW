package ru.otus.slot;

import ru.otus.output.Money;

public class MoneySlot {

    /**
     * Номинал купюры
     */
    private int denomination;

    /**
     * Следующий слот(ячейка) с деньгами
     */
    private MoneySlot moneySlotNext;

    /**
     * Constructor
     *
     * @param denomination номинал купюры
     */
    public MoneySlot( int denomination ) {
        this.denomination = denomination;
    }

    /**
     * Выдать сумму денег
     *
     * @param money объект класса Money
     */
    public void givingCash( Money money ) {
        int countBanknote = money.getRequestMoney() / this.denomination;
        int remains = money.getRequestMoney() % this.denomination;

        if ( countBanknote > 0 ) {
            System.out.println( "Купюра " + this.denomination + " " + countBanknote + " шт." );
        }

        if ( remains > 0 && moneySlotNext != null ) {
            moneySlotNext.givingCash( new Money( remains ) );
        }
    }

    /**
     * Назначить следующий слот(ячейку)
     *
     * @param slot ячейка с деньгами
     */
    public void setMoneySlotNext( MoneySlot slot ) {
        this.moneySlotNext = slot;
    }

}
