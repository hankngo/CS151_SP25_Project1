package model;

public class Employee {
    private String fname;
    private String lname;
    private int code; 
    private int hoursWorked;

    public Employee(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.hoursWorked = 0;
    }

    public String getName() {
        return this.fname + " " + this.lname;
    }

    public void trackHours(int hours) {
        this.hoursWorked += hours;
    }

    public int getCode() {
        return this.code;
    }

    public int getHoursWorked() {
        return this.hoursWorked;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
