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
import exceptions.EmployeeSystemException;
import exceptions.TooManyInstanceException;

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
    public void addEmployeeByName(String fname, String lname, Employee manager) throws IllegalArgumentException, EmployeeSystemException, TooManyInstanceException {
        if (employees.size() >= 100) {throw new TooManyInstanceException("Too many instances! Cart can only add up to 100 items.");}

        if (manager == null) {throw new IllegalArgumentException("Invalid argument. Manager is null!");}
        if (!isManager(manager)) {throw new EmployeeSystemException("Access Denied: Only a manager can add employees.");}

        boolean isFound = false;
        for (Employee e : employees.keySet()) {
            if (e.getName().equals(fname + " " + lname)) {
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            Employee newEmployee = new Employee(fname, lname);
            int code;
            do {
                code = random.nextInt(1000);
            } while (login(code) != null);
            newEmployee.setCode(code);
            employees.put(newEmployee, "employee");
            System.out.printf("%s added with code: %d.\n", newEmployee.getName(), code);
        } else {
            throw new EmployeeSystemException("Employee already exists. Please enter a different name!");
        }
    }

    /**
     * Remove an employee with a unique code. But only the manager able to do so.
     */
    @Override
    public void removeEmployeeByCode(int code, Employee manager) throws IllegalArgumentException, EmployeeSystemException {
        if (manager == null || !isManager(manager)) {
            throw new EmployeeSystemException("Access Denied: Only a manager can add employees.");
        }

        Employee foundEmployee = null;
        for (Employee e : employees.keySet()) {
            if (e.getCode() == code) {
                foundEmployee = e;
                break;
            }
        }
        
        if (foundEmployee != null) {
            if (!employees.get(foundEmployee).equals(AUTHORIZED)) {
                employees.remove(foundEmployee);
                System.out.printf("Employee with code=%d is removed from the system.\n", code);
            } else {
                throw new EmployeeSystemException("You can't remove yourself as the manager!");
            }
        } else {
            throw new EmployeeSystemException("Employee not found. Re-enter the code!");
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
    public void trackEmployeeHours(Employee employee, double hours) {
        employee.trackHours(hours);
        System.out.println(employee.getName() + " has " + employee.getHoursWorked() + " hours worked.");
    }
}
