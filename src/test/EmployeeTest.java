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
        assertEquals("John Doe", employee.getName());
    }

    @Test
    void testTrackHours() {
        employee.trackHours(5.5);
        assertEquals(5.5, employee.getHoursWorked());
    }

    @Test
    void testGetCode() {
        employee.setCode(1234);
        assertEquals(1234, employee.getCode());
    }

    @Test
    void testSetCode() {
        employee.setCode(4321);
        assertEquals(4321, employee.getCode());
    }

    @Test
    void testAccumulateHours() {
        employee.trackHours(3.0);
        employee.trackHours(4.5);
        assertEquals(7.5, employee.getHoursWorked());
    }
}