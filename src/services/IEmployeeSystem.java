/*
 * `IEmployeeSystem` defines an interface for employee management.
 * Implemented by `EmployeeSystem`
 */


package services;

import model.Employee;

public interface IEmployeeSystem {
    void addEmployee(Employee employee, Employee manager); // Adds a new employee
    Employee login(int code); // Authenticates an employee using a unique code
    boolean isManager(Employee employee); // Checks if the employee is a manager
    void trackEmployeeHours(Employee employee, int hours); // Logs working hours
}
