package machines;

import exceptions.MachineFailureException;

public abstract class Machine implements Maintainable {

    private boolean brokenStatus;
    private int uses;

    public static double totalMachineRepairCosts = 0.0;

    public Machine()
    {
        this.brokenStatus = false;
        this.uses = 0;
    }

    @Override
    public int getUses()
    {
        return this.uses;
    }

    @Override
    public void setUses(int num)
    {
        this.uses = num;
    }

    @Override
    public void addUses(int num)
    {
        this.uses += num;
    }

    protected abstract void useMachine() throws MachineFailureException;

    @Override
    public boolean getBrokenStatus() {
        return this.brokenStatus;
    }

    @Override
    public void setBrokenStatus(boolean status)
    {
        this.brokenStatus = status;
    }

    protected abstract void fix();

    @Override
    public abstract double failureOdds();
}
