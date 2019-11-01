package ru.otus.atm;

import ru.otus.cash.Banknotes;
import ru.otus.request.Request;

import java.util.List;

public interface Atm {

    /**
     * Инициализация
     */
    void initialize();

    /**
     * Ввод банкнот
     *
     * @param banknotes Массив чисел
     */
    void banknotesIn( int[] banknotes );

    /**
     * Ввод банкнот с сохранением состояния кассет
     *
     * @param banknotes Массив чисел
     * @param save Флаг {true,false}
     */
    void banknotesIn( int[] banknotes, boolean save );

    /**
     * Печать содержимого кассет
     *
     * @return Строка данных
     */
    String toStringCassettes();

    /**
     * Вывод банкнот
     *
     * @param requestMoney объект запроса
     * @return Коллекция банкноты
     */
    List<Banknotes> banknotesOut( Request requestMoney );

    /**
     * Getter name
     *
     * @return Имя банкомата
     */
    String getName();

    /**
     * Создать объект с состоянием кассет (Memento)
     *
     * @return Объект DefaultStateAtm
     */
    DefaultStateAtm saveCassettes();

    /**
     * Восстановить значения кассет
     */
    void restoreCassettes();

    /**
     * Печать остатка денежных средств
     */
    String getCashBalance();

}
