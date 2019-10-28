package ru.otus.commands;

import ru.otus.department.Department;

public class CommandPrintCashBalance implements Command {

    private Department department;

    public CommandPrintCashBalance( Department department ) {
        this.department = department;
    }

    @Override
    public void execute() {
        this.department.printCashBalance();
    }

}
