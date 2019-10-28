package ru.otus.department;

import ru.otus.atm.observer.Observer;

public interface Subject {

    /**
     * Регистрация наблюдателя
     *
     * @param observer объект наблюдатель
     */
    void registerObserver( Observer observer );

    /**
     * Удаление наблюдателя
     *
     * @param observer объект наблюдатель
     */
    void removeObserver( Observer observer );

    /**
     * Печать остатка денежных средств у всех подписавшихся наблюдателей
     */
    void printCashBalance();

}
