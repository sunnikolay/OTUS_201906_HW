package ru.otus.commands;

import ru.otus.department.Department;

public class CommandATMPrintCashBalance implements CommandATM {

    private Department department;

    public CommandATMPrintCashBalance( Department department ) {
        this.department = department;
    }

    @Override
    public void execute() {
        //this.department.printCashBalance();
    }

}
