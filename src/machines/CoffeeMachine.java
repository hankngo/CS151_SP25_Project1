package machines;

import exceptions.MachineFailureException;

public class CoffeeMachine extends Machine {

    int numCoffeeMachines = 0;

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
    public void useMachine() throws MachineFailureException
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
    public void fix()
    {
        setBrokenStatus(false);
        //either set to zero or subtract a certain percent (i.e. 70%) of uses from the uses counter
        addUses(0);
        System.out.println("Repairing...");
        //100-500 dollars
        double randomCost = (int)(((Math.random() * 400) + 100) * 100) / 100.0;
        totalMachineRepairCosts += randomCost;
        totalMachineRepairCosts = (int)(totalMachineRepairCosts * 100) / 100.0;
    }

    public double failureOdds()
    {
        return 0.0001 + (0.0001 * getUses());
    }

}
