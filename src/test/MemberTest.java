/* 
* This the extra credit JUNIT test class for the membership functionality 
*/
package test;

import membership.Member;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MemberTest {

    /* tests for invalid phone number length */
    @Test
    void testInvalidPhoneNumberLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Member("John", "Doe", "12345", Member.Tier.BRONZE)
        );
        assertEquals("Invalid phone number. Must be 10 digits.", exception.getMessage());
    }

    /* tests for if the user puts no first name */
    @Test
    void testNoFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Member("", "Doe", "1234567890", Member.Tier.BRONZE)
        );
        assertEquals("No first name provided.", exception.getMessage());
    }

    /* tests for if the user puts no last name */
    @Test
    void testNoLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Member("John", "", "1234567890", Member.Tier.BRONZE)
        );
        assertEquals("No last name provided.", exception.getMessage());
    }
}
