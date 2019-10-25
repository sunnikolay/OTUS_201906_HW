package ru.otus;

import ru.otus.atm.Atm;
import ru.otus.atm.AtmImpl;
import ru.otus.atm.AtmKeeper;
import ru.otus.cash.Cash;
import ru.otus.department.Department;
import ru.otus.request.Request;

public class StartApp {

    public static void main( String[] args ) {

        String nameDepart1 = "Department №1";
        String nameDepart2 = "Department №2";

        // Банкноты для загрузки в банкоматы
        int[] uploadBanknotes = {
                100, 100, 100, 100, 100,
                200, 200, 200, 200, 200,
                500, 500, 500, 500, 500,
                1000, 1000, 1000, 1000, 1000,
                5000, 5000, 5000, 5000, 5000
        };

        int[] smallUploadBanknotes = { 100, 200, 500, 1000, 5000 };

        // Департамент №1
        Department department1 = new Department( nameDepart1 );
        AtmKeeper atmKeeper = new AtmKeeper();
        Atm        atm1  = new AtmImpl( nameDepart1 + "; ATM: 1" );
        Atm        atm2  = new AtmImpl( nameDepart1 + "; ATM: 2" );
        Atm        atm3  = new AtmImpl( nameDepart1 + "; ATM: 3" );
        Atm        atm4  = new AtmImpl( nameDepart1 + "; ATM: 4" );
        department1.addAtm( atm1 );
        department1.addAtm( atm2 );
        department1.addAtm( atm3 );
        department1.addAtm( atm4 );
        department1.uploadBanknotes( atm1, smallUploadBanknotes );
        department1.uploadBanknotes( atm2, uploadBanknotes );
        department1.uploadBanknotes( atm3, uploadBanknotes );
        department1.uploadBanknotes( atm4, uploadBanknotes );
        atmKeeper.setMemento( atm1.saveCasettes() );

//        // Департамент №2
//        Department department2 = new Department( nameDepart1 );
//        Atm        atm5  = new AtmImpl( nameDepart2 + "; ATM: 1" );
//        Atm        atm6  = new AtmImpl( nameDepart2 + "; ATM: 2" );
//        Atm        atm7  = new AtmImpl( nameDepart2 + "; ATM: 3" );
//        Atm        atm8  = new AtmImpl( nameDepart2 + "; ATM: 4" );
//        department2.addAtm( atm5 );
//        department2.addAtm( atm6 );
//        department2.addAtm( atm7 );
//        department2.addAtm( atm8 );
//        department2.uploadBanknotes( atm5, uploadBanknotes );
//        department2.uploadBanknotes( atm6, uploadBanknotes );
//        department2.uploadBanknotes( atm7, uploadBanknotes );
//        department2.uploadBanknotes( atm8, uploadBanknotes );

//        int[] inNotes = { 100, 100, 100, 100, 200, 200, 200, 500, 500, 500, 1000, 1000, 1000, 1000, 5000, 5000, 5000, 5000 };
//        atm.banknotesIn( inNotes );
//
//        // Запрос на выдачу денег
//        Request r1 = new Request( 10800 );
//        Request r2 = new Request( 7900 );
//        Request r3 = new Request( 8000 );
//        Request r4 = new Request( 7800 );
//
//        Cash cash1 = new Cash( atm.banknotesOut( r1 ) );
//        System.out.println( cash1.getBanknotes() );
//        atm.showCassetes();
//
//        Cash cash2 = new Cash( atm.banknotesOut( r2 ) );
//        System.out.println( cash2.getBanknotes() );
//        atm.showCassetes();
//
//        Cash cash3 = new Cash( atm.banknotesOut( r3 ) );
//        System.out.println( cash3.getBanknotes() );
//        atm.showCassetes();
//
//        Cash cash4 = new Cash( atm.banknotesOut( r4 ) );
//        System.out.println( cash4.getBanknotes() );
//        atm.showCassetes();
    }

}
