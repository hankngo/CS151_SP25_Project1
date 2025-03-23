package machines;

import cafe.MenuItem;
import cafe.MenuItemSubclasses;
import exceptions.MachineFailureException;
import exceptions.TooManyInstanceException;

public class EspressoMachine extends Machine {

    private int numEspressoMachines = 0;

    public EspressoMachine()
    {
        numEspressoMachines++;
    }

    public boolean checkEspresso(MenuItem m)
    {
        if(m instanceof MenuItemSubclasses.LatteCoffee)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void createEspresso(int num)
    {
        System.out.println("Attempting to create espresso...");
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
        System.out.println("Created " + num + " orders of espresso.");
    }

    @Override
    protected void useMachine() throws MachineFailureException
    {
        double random = Math.random();
        double failureOdds = failureOdds();

        if(random < failureOdds)
        {
            setBrokenStatus(true);
            System.out.println("Espresso machine broke.");
            throw new MachineFailureException("The espresso machine needs to be repaired.");
        }
    }

    public int getNumEspressoMachines()
    {
        return numEspressoMachines;
    }

    public void setNumEspressoMachines(int num) throws TooManyInstanceException
    {
        if(num > 100)
        {
            throw new TooManyInstanceException("Please input a positive integer less than 100.");
        }
        
        numEspressoMachines = num;
    }

    @Override
    protected void fix()
    {
        setBrokenStatus(false);
        //Subtract 70% of uses from the uses counter to simulate realism in repairing machine
        addUses(-1 * (int)(getUses() * 0.7));
        System.out.println("Repaired espresso machine.");

        //Cost of repair: $150-550
        double randomCost = (int)(((Math.random() * 400) + 150) * 100) / 100.0;
        totalMachineRepairCosts += randomCost;
        totalMachineRepairCosts = (int)(totalMachineRepairCosts * 100) / 100.0;
    }

    @Override
    public double failureOdds()
    {
        return 0.0001 + (0.00011 * getUses());
    }
    
}
