package ru.otus.commands;

import ru.otus.atm.Atm;
import ru.otus.department.Department;

public class CommandRestoreATM implements Command {

    private Department department;
    private Atm        atm;
    private boolean    resetAllATM;

    /**
     * Constructor
     *
     * @param department объект Департамент
     */
    public CommandRestoreATM( Department department, Atm atm ) {
        this.department  = department;
        this.atm         = atm;
        this.resetAllATM = false;
    }

    /**
     * Constructor
     *
     * @param department  объект Департамент
     * @param resetAllATM флаг восстановить все ATM
     */
    public CommandRestoreATM( Department department ) {
        this.department  = department;
        this.resetAllATM = true;
    }

    @Override
    public void execute() {
        if ( this.resetAllATM ) this.department.restoreAllATM();
        else this.department.restoreATM( this.atm );
    }

}
