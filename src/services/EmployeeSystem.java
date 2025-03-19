/*
 * `EmployeeSystem` implements `IEmployeeSystem` and manages:
 * - Employee authentication via login.
 * - Assigning unique employee codes.
 * - Checking if an employee is a manager (`isManager()`).
 * - Tracking employee working hours.
 */


package services;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;

import model.Employee;

public class EmployeeSystem implements IEmployeeSystem {
    private static final int MANAGERCODE = 151; // default
    private static final String AUTHORIZED = "manager"; // default
    private static final Random random = new Random();
    
    private static final EmployeeSystem es = new EmployeeSystem(); // Singleton instance
    private Map<Employee, String> employees = new HashMap<>();

    /**
     * Private constructor prevents external instantiation.
     * Initializes the system with a default "Owner" as the manager.
     */
    private EmployeeSystem() {
        Employee manager = new Employee("Owner", "");
        manager.setCode(MANAGERCODE);
        employees.put(manager, AUTHORIZED);
    }

    /** 
     * Exposes functionality via `IEmployeeSystem` without revealing `EmployeeSystem` internals. 
     */
    public static IEmployeeSystem getEmployeeSystem() {
        return es;
    }

    /**
     * Adds a new employee with a unique code. But only the manager able to do so.
     */
    @Override
    public void addEmployee(Employee employee, Employee manager) {
        if (employee == null) {  
            System.out.println("Error: Cannot add a null employee.");
            return;
        }

        if (manager == null || !isManager(manager)) {
            System.out.println("Access Denied: Only a manager can add employees.");
            return;
        }

        if (!employees.containsKey(employee)) {
            int code;
            do {
                code = random.nextInt(1000);
            } while (login(code) != null);
            employee.setCode(code);
            employees.put(employee, "employee");
            System.out.println(employee.getName() + " added with code: " + code);
        } else {
            System.out.println("Employee already exists.");
        }
    }

    /**
     * Authenticates an employee by their unique code.
     * Returns the `Employee` object if found, otherwise returns `null`.
     */
    @Override
    public Employee login(int code) {
        for(Employee e : employees.keySet()) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    /**
     * Checks if the given employee is a manager by verifying their authorization status.
     */
    @Override
    public boolean isManager(Employee employee) {
        return employees.containsKey(employee) && employees.get(employee).equals(AUTHORIZED);
    }

    @Override
    public void trackEmployeeHours(Employee employee, int hours) {
        employee.trackHours(hours);
        System.out.println(employee.getName() + " has " + employee.getHoursWorked() + " hours worked.");
    }
}
