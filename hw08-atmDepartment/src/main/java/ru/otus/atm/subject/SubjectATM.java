package ru.otus.atm.subject;

import ru.otus.department.observer.BalanceObserverATM;

public interface SubjectATM {

    /**
     * Регистрация наблюдателя
     *
     * @param observer объект наблюдатель
     */
    void registerObserver( BalanceObserverATM observer );

    /**
     * Удаление наблюдателя
     *
     * @param observer объект наблюдатель
     */
    void removeObserver( BalanceObserverATM observer );

    /**
     * Оповещение наблюдателей
     */
    void notifyObservers();

}
