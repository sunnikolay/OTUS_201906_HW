package ru.otus.department;

import ru.otus.atm.Atm;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private String    name;
    private List<Atm> atms;

    public Department( String name ) {
        this.name = name;
        this.atms = new ArrayList<>();
    }

    public void addAtm( Atm atm ) {
        this.atms.add( atm );
    }

    public void removeAtm( Atm atm ) {
        this.atms.remove( atm );
    }

    public void uploadBanknotes( Atm atm, int[] banknotes ) {
        atm.banknotesIn( banknotes );
    }

    /**
     * Вывод в консоль всех ATM в данном Department
     */
    public void printAllAtm() {
        System.out.println( "Print all ATM in " + this.name );
        for ( Atm atm : this.atms ) {
            System.out.println( atm.getName() );
        }
    }

    public String getName() {
        return name;
    }

}
