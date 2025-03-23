package machines;

import exceptions.MachineFailureException;
import exceptions.TooManyInstanceException;

public class CoffeeMachine extends Machine {

    private int numCoffeeMachines = 0;

    public CoffeeMachine() throws TooManyInstanceException
    {
        if(numCoffeeMachines > 100)
        {
            throw new TooManyInstanceException("Too many coffee machines! (>100)");
        }
        else
        {
            numCoffeeMachines++;
        }
    }

    public void createCoffee(int num)
    {
        System.out.println("Attempting to create coffee...");
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
        System.out.println("Created " + num + " orders of coffee.");
    }

    @Override
    protected void useMachine() throws MachineFailureException
    {
        double random = Math.random();
        double failureOdds = failureOdds();

        if(random < failureOdds)
        {
            setBrokenStatus(true);
            System.out.println("Coffee machine broke.");
            throw new MachineFailureException("The coffee machine needs to be repaired.");
        }
    }

    @Override
    protected void fix()
    {
        setBrokenStatus(false);
        //Subtract 70% of uses from the uses counter to simulate realism in repairing machine
        addUses(-1 * (int)(getUses() * 0.7));
        System.out.println("Repaired coffee machine.");

        //Cost of repair: $100-500
        double randomCost = (int)(((Math.random() * 400) + 100) * 100) / 100.0;
        totalMachineRepairCosts += randomCost;
        totalMachineRepairCosts = (int)(totalMachineRepairCosts * 100) / 100.0;
    }

    public void setNumCoffeeMachines(int num)
    {
        numCoffeeMachines = num;
    }

    public int getNumCoffeeMachines()
    {
        return numCoffeeMachines;
    }

    @Override
    public double failureOdds()
    {
        return 0.0001 + (0.0001 * getUses());
    }

}
