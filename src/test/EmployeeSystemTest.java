package test;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Employee;
import services.EmployeeSystem;
import services.IEmployeeSystem;
import exceptions.EmployeeSystemException;
import exceptions.TooManyInstanceException;

public class EmployeeSystemTest {

    @Test
    public void testManagerCanAddEmployee() throws Exception {
        IEmployeeSystem es = EmployeeSystem.getEmployeeSystem();
        Employee manager = es.login(151); 

        es.addEmployeeByName("John", "Doe", manager);

        // check for every code < 1000 to find the code of new employee
        // and the code shouldn't be the same
        Employee found = null;
        for (int code = 0; code < 1000; code++) {
            if(code == 151)
            {
                continue;
            }
            Employee e = es.login(code);
            if (e != null) {
                found = e;
                break;
            }
        }

        assertNotNull(found);
        assertEquals("John Doe", found.getName());
    }

    @Test(expected = EmployeeSystemException.class)
    public void testNonManagerCannotAddEmployee() throws Exception {
        IEmployeeSystem es = EmployeeSystem.getEmployeeSystem();
        Employee manager = es.login(151);
        es.addEmployeeByName("Jane", "Doe", manager);
        Employee nonManager = null;

        // get the nonManager employee
        for (int code = 0; code < 1000; code++) {
            Employee e = es.login(code);
            if (e != null && e.getName().equals("Jane Doe")) {
                nonManager = e;
                break;
            }
        }

        es.addEmployeeByName("Fail", "Test", nonManager);
    }

    @Test
    public void testTrackHours() {
        Employee emp = new Employee("Test", "Employee");
        emp.setCode(123);
        IEmployeeSystem es = EmployeeSystem.getEmployeeSystem();

        es.trackEmployeeHours(emp, 5.0);
        assertEquals(5.0, emp.getHoursWorked(), 0.01);
    }

    @Test(expected = EmployeeSystemException.class)
    public void testRemoveManagerThrows() throws Exception {
        IEmployeeSystem es = EmployeeSystem.getEmployeeSystem();
        Employee manager = es.login(151);
        es.removeEmployeeByCode(151, manager); // Should not allow removing manager themselve
    }
}