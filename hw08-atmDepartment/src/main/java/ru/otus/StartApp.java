package ru.otus;

import ru.otus.atm.Atm;
import ru.otus.atm.AtmImpl;
import ru.otus.commands.Command;
import ru.otus.commands.CommandPrintCashBalance;
import ru.otus.commands.CommandRestoreATM;
import ru.otus.department.Department;

public class StartApp {

    public static void main( String[] args ) {

        String nameDepart1 = "Department №1";
        String nameDepart2 = "Department №2";

        // Банкноты для загрузки в банкоматы
        int[] ub1 = { 5000 };
        int[] ub2 = { 100, 200, 500, 1000, 5000 };
        int[] ub3 = {
                100, 100, 100, 100, 100,
                200, 200, 200, 200, 200,
                500, 500, 500, 500, 500,
                1000, 1000, 1000, 1000, 1000,
                5000, 5000, 5000, 5000, 5000
        };

        // Департаменты
        Department department1 = new Department( nameDepart1 );
        Department department2 = new Department( nameDepart2 );
        Atm        atm1        = new AtmImpl( nameDepart1 + "; ATM: 1", department1 );
        Atm        atm2        = new AtmImpl( nameDepart1 + "; ATM: 2", department1 );
        Atm        atm3        = new AtmImpl( nameDepart2 + "; ATM: 3", department2 );
        Atm        atm4        = new AtmImpl( nameDepart2 + "; ATM: 4", department2 );
        department1.addATM( atm1 );
        department1.addATM( atm2 );
        department2.addATM( atm3 );
        department2.addATM( atm4 );
        department1.printAllAtm();
        department2.printAllAtm();

        // Загрузка банкнот
        department1.uploadBanknotes( atm1, ub1, true );
        department1.uploadBanknotes( atm1, ub1, false );
        department1.uploadBanknotes( atm2, ub1, true );
        department1.uploadBanknotes( atm2, ub1, false );
        department2.uploadBanknotes( atm3, ub2, true );
        department2.uploadBanknotes( atm3, ub3, false );
        department2.uploadBanknotes( atm4, ub3, true );
        department2.uploadBanknotes( atm4, ub1, false );
        department1.printCurrentStateAllATM();
        department2.printCurrentStateAllATM();

        // Восстановление ATM's
        System.out.println( "----------------------------------" );
        Command restoreAtm = new CommandRestoreATM( department1, atm1 );
        Command restoreAllAtm = new CommandRestoreATM( department1 );
        restoreAtm.execute();
        restoreAllAtm.execute();

        restoreAllAtm = new CommandRestoreATM( department2 );
        restoreAllAtm.execute();

        department1.printCurrentStateAllATM();
        department2.printCurrentStateAllATM();

        // Печать баланса
        System.out.println( "----------------------------------" );
        Command printCashBalance = new CommandPrintCashBalance( department1 );
        printCashBalance.execute();

        printCashBalance = new CommandPrintCashBalance( department2 );
        printCashBalance.execute();

    }

}
