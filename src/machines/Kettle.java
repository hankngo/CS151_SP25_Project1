package machines;

import exceptions.MachineFailureException;
import exceptions.TooManyInstanceException;

public class Kettle extends Machine {

    private int numKettles = 0;

    public Kettle() throws TooManyInstanceException
    {
        if(numKettles > 100)
        {
            throw new TooManyInstanceException("Too many kettle machines! (>100)");
        }
        else
        {
            numKettles++;
        }
    }

    public void createTea(int num)
    {
        System.out.println("Attempting to create tea...");
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
        System.out.println("Created " + num + " orders of tea.");
    }

    @Override
    protected void useMachine() throws MachineFailureException
    {
        double random = Math.random();
        double failureOdds = failureOdds();

        if(random < failureOdds)
        {
            setBrokenStatus(true);
            System.out.println("Kettle broke.");
            throw new MachineFailureException("The kettle needs to be repaired.");
        }
    }

    @Override
    protected void fix()
    {
        setBrokenStatus(false);
        //Subtract 70% of uses from the uses counter to simulate realism in repairing machine
        addUses(-1 * (int)(getUses() * 0.7));
        System.out.println("Repaired kettle.");

        //Cost of repair: $75-150
        double randomCost = (int)(((Math.random() * 75) + 75) * 100) / 100.0;
        totalMachineRepairCosts += randomCost;
        totalMachineRepairCosts = (int)(totalMachineRepairCosts * 100) / 100.0;
    }

    @Override
    public double failureOdds()
    {
        return 0.0001 + (0.00003 * getUses());
    }
    
}
