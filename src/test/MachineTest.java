package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import machines.*;
import exceptions.*;

public class MachineTest {

    private CoffeeMachine coffeeMachine;
    private EspressoMachine espressoMachine;
    private Kettle kettle;
    private Oven oven;

    @BeforeEach
    public void createMachines()
    {
        coffeeMachine = new CoffeeMachine();
        espressoMachine = new EspressoMachine();
        kettle = new Kettle();
        oven = new Oven();
    }

    @Test
    public void testTooManyCoffeeMachines()
    {
        assertThrows(TooManyInstanceException.class, () -> coffeeMachine.setNumCoffeeMachines(101));
    }

    @Test
    public void testTooManyEspressoMachines()
    {
        assertThrows(TooManyInstanceException.class, () -> espressoMachine.setNumEspressoMachines(101));
    }

    @Test
    public void testTooManyKettles()
    {
        assertThrows(TooManyInstanceException.class, () -> kettle.setNumKettles(101));
    }

    @Test
    public void testTooManyOvens()
    {
        assertThrows(TooManyInstanceException.class, () -> oven.setNumOvens(101));
    }

    @Test
    public void extremeCoffeeMachineUsage()
    {
        coffeeMachine.setUses(99999);
        //Should auto-fix the broken status
        coffeeMachine.createCoffee(1);
    }
}
