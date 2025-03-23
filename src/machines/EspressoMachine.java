package machines;

import exceptions.MachineFailureException;

public class EspressoMachine extends Machine {

    @Override
    public void useMachine() throws MachineFailureException {
        return;
    }

    @Override
    public void fix() {
        return;
    }

    @Override
    public double failureOdds() {
        return 0.0;
    }
    
}
