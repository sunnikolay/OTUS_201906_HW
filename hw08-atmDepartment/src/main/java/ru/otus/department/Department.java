package ru.otus.department;

import ru.otus.atm.Atm;
import ru.otus.atm.AtmImpl;
import ru.otus.department.observer.BalanceObserverATM;

import java.util.ArrayList;
import java.util.List;

public class Department implements BalanceObserverATM {

    /**
     * Имя департамента
     */
    private String name;

    /**
     * Список банкоматов
     */
    private List<Atm> atms;

    /**
     * Баланс департамента
     */
    private int balanceDepartment;

    /**
     * Constructor
     *
     * @param name имя департамента
     */
    public Department( String name ) {
        this.name = name;
        this.atms = new ArrayList<>();
    }

    /**
     * Создать баномат в департаменте
     *
     * @param atm Объект ATM
     */
    public void addATM( AtmImpl atm ) {
        this.atms.add( atm );
        atm.registerObserver( this );
    }

    /**
     * Загрузить банкноты в банкомат
     *
     * @param banknotes Массив чисел
     * @param save      Флаг, сохранить состояние банкомата
     */
    public void uploadBanknotes( Atm atm, int[] banknotes, boolean save ) {
        if ( save ) atm.banknotesIn( banknotes, true );
        else atm.banknotesIn( banknotes );
    }

    /**
     * Восстановить сохраненное состояние банкомата
     *
     * @param atm Банкомат
     */
    public void restoreATM( Atm atm ) {
        atm.restoreCassettes();
    }

    /**
     * Восстановить сохраненное состояние у всех банкоматов
     */
    public void restoreAllATM() {
        for ( Atm atm : this.atms ) {
            restoreATM( atm );
        }
    }

    /**
     * Печать всех ATM в данном Department
     */
    public void printAllAtm() {
        System.out.println( "Print all ATM in " + this.name );
        for ( Atm atm : this.atms ) {
            System.out.println( atm.getName() );
        }
    }

    @Override
    public void balanceChangeAtm() {

    }

}
