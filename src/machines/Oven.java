package machines;

import exceptions.MachineFailureException;
import exceptions.TooManyInstanceException;

public class Oven extends Machine {

    private int numOvens = 0;

    public Oven() throws TooManyInstanceException
    {
        if(numOvens > 100)
        {
            throw new TooManyInstanceException("Too many ovens! (>100)");
        }
        else
        {
            numOvens++;
        }
    }

    public void createPastries(int num)
    {
        System.out.println("Attempting to create bread/pastries...");
        for(int i = 0; i < num; i++)
        {
            try 
            {
                useMachine();
            } 
            catch (MachineFailureException e) 
            {
                e.getMessage();
                fix();
            }
            finally
            {
                addUses(1);
            }
        }
        System.out.println("Created " + num + " orders of bread/pastries.");
    }

    @Override
    protected void useMachine() throws MachineFailureException
    {
        double random = Math.random();
        double failureOdds = failureOdds();

        if(random < failureOdds)
        {
            setBrokenStatus(true);
            System.out.println("Oven broke.");
            throw new MachineFailureException("The oven needs to be repaired.");
        }
    }

    @Override
    protected void fix()
    {
        setBrokenStatus(false);
        //Subtract 70% of uses from the uses counter to simulate realism in repairing machine
        addUses(-1 * (int)(getUses() * 0.7));
        System.out.println("Repaired oven.");

        //Cost of repair: $150-900
        double randomCost = (int)(((Math.random() * 750) + 150) * 100) / 100.0;
        totalMachineRepairCosts += randomCost;
        totalMachineRepairCosts = (int)(totalMachineRepairCosts * 100) / 100.0;
    }

    @Override
    public double failureOdds()
    {
        return 0.0001 + (0.00007 * getUses());
    }
}
