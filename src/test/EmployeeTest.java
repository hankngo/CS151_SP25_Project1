package test;

import model.Employee;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("John", "Doe");
    }

    @Test
    void testGetName() {
        assertEquals("John Doe", employee.getName(), "The name should be correctly concatenated.");
    }

    @Test
    void testTrackHours() {
        employee.trackHours(5.5);
        assertEquals(5.5, employee.getHoursWorked(), "Hours worked should be updated correctly.");
    }

    @Test
    void testGetCode() {
        employee.setCode(1234);
        assertEquals(1234, employee.getCode(), "The employee code should be retrievable.");
    }

    @Test
    void testSetCode() {
        employee.setCode(4321);
        assertEquals(4321, employee.getCode(), "The employee code should be set correctly.");
    }

    @Test
    void testAccumulateHours() {
        employee.trackHours(3.0);
        employee.trackHours(4.5);
        assertEquals(7.5, employee.getHoursWorked(), "Hours worked should accumulate correctly.");
    }
}