package machines;

import exceptions.MachineFailureException;

public interface Maintainable {

    int getUses();
    void setUses(int num);
    void addUses(int num);
    boolean getBrokenStatus();
    void setBrokenStatus(boolean status);
    double failureOdds();

}
