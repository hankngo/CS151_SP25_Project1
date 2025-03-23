package machines;

import exceptions.MachineFailureException;
import exceptions.TooManyInstanceException;

public class EspressoMachine extends Machine {

    private int numEspressoMachines = 0;

    public EspressoMachine() throws TooManyInstanceException
    {
        if(numEspressoMachines > 100)
        {
            throw new TooManyInstanceException("Too many espresso machines! (>100)");
        }
        else
        {
            numEspressoMachines++;
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

    @Override
    protected void fix()
    {
        setBrokenStatus(false);
        //Subtract 70% of uses from the uses counter to simulate realism in repairing machine
        addUses(-1 * (int)(getUses() * 0.7));
        System.out.println("Repaired espresso machine.");

        //Cost of repair: $150-500
        double randomCost = (int)(((Math.random() * 400) + 150) * 100) / 100.0;
        totalMachineRepairCosts += randomCost;
        totalMachineRepairCosts = (int)(totalMachineRepairCosts * 100) / 100.0;
    }

    @Override
    public double failureOdds()
    {
        return 0.0001 + (0.0001 * getUses());
    }
    
}
