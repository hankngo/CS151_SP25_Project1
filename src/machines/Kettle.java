package machines;

import cafe.MenuItem;
import cafe.MenuItemSubclasses;
import exceptions.MachineFailureException;
import exceptions.TooManyInstanceException;

public class Kettle extends Machine {

    private int numKettles = 0;

    public Kettle()
    {
        numKettles++;
    }

    public boolean checkTea(MenuItem m)
    {
        if(m instanceof MenuItemSubclasses.ColdTea || m instanceof MenuItemSubclasses.HotTea)
        {
            return true;
        }
        else
        {
            return false;
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

    public int getNumKettles()
    {
        return numKettles;
    }

    public void setNumKettles(int num) throws TooManyInstanceException
    {
        if(num > 100)
        {
            throw new TooManyInstanceException("Please input a positive integer less than 100.");
        }
        
        numKettles = num;
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
