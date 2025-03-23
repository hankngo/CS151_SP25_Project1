package machines;

public interface Maintainable {

    void useMachine() throws MachineFailureException;
    int getUses();
    void setUses(int num);
    void addUses(int num);
    boolean getBrokenStatus();
    void setBrokenStatus(boolean status);
    void fix();
    double failureOdds();

}
