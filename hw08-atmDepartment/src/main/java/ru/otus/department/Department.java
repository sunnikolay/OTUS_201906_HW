package ru.otus.department;

import ru.otus.atm.Atm;
import ru.otus.atm.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Department implements Subject {

    private String         name;
    private List<Atm>      atms;
    private List<Observer> observers;

    public Department( String name ) {
        this.name      = name;
        this.atms      = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Создать баномат в департаменте
     *
     * @param atm Объект ATM
     */
    public void addATM( Atm atm ) {
        this.atms.add( atm );
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

    private void printCurrentStateATM( Atm atm ) {
        System.out.println( atm.toStringCassettes() );
    }

    public void printCurrentStateAllATM() {
        for ( Atm atm : this.atms ) {
            this.printCurrentStateATM( atm );
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

    /**
     * Getter name
     *
     * @return Название Департамента
     */
    public String getName() {
        return name;
    }

    /**
     * Getter atms
     *
     * @return Колекция банкоматов департамента
     */
    public List<Atm> getAtms() {
        return atms;
    }

    @Override
    public void registerObserver( Observer observer ) {
        this.observers.add( observer );
    }

    @Override
    public void removeObserver( Observer observer ) {
        this.observers.remove( observer );
    }

    @Override
    public void printCashBalance() {
        for ( Observer observer : this.observers ) {
            observer.printCashBalance();
        }
    }

}
