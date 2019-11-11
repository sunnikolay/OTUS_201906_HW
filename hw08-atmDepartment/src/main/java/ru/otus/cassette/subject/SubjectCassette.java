package ru.otus.cassette.subject;

import ru.otus.atm.observer.BalanceObserverCassette;

public interface SubjectCassette {

    /**
     * Регистрация наблюдателя
     *
     * @param observer объект наблюдатель
     */
    void registerObserver( BalanceObserverCassette observer );

    /**
     * Удаление наблюдателя
     *
     * @param observer объект наблюдатель
     */
    void removeObserver( BalanceObserverCassette observer );

    /**
     * Оповещение наблюдателей
     */
    void notifyObservers( String action );

}
