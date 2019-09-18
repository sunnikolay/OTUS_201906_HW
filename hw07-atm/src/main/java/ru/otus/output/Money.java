package ru.otus.output;

import ru.otus.slot.Banknote;

public class Money {

    private int requestMoney;

    public Money( int requestMoney ) {
        setRequestMoney( requestMoney );
    }

    public int getRequestMoney() {
        return requestMoney;
    }

    /**
     * Проверка запрашиваемой суммы
     *
     * @param requestMoney запрашиваемая сумма
     */
    private void setRequestMoney( int requestMoney ) {
        // TODO надо как то убрать номинал RUB_100
        if ( requestMoney > 0 && requestMoney % Banknote.RUB_100 == 0 ) {
            this.requestMoney = requestMoney;
        }
        else {
            System.out.println( "Сумма денег должна быть кратная 100 рублям." );
        }
    }

}
