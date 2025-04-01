package membership;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void testInvalidPhoneNumberLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Member("John", "Doe", "12345", Member.Tier.BRONZE)
        );
        assertEquals("Invalid phone number. Must be 10 digits.", exception.getMessage());
    }

    @Test
    void testDuplicatePhoneNumber() {
        MemberManager.signUp("Alice", "Smith", "1234567890", Member.Tier.SILVER);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            MemberManager.signUp("Bob", "Johnson", "1234567890", Member.Tier.GOLD)
        );
        assertEquals("Invalid phone number. Phone number already in use.", exception.getMessage());
    }

    @Test
    void testNoFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Member("", "Doe", "1234567890", Member.Tier.BRONZE)
        );
        assertEquals("No first name provided.", exception.getMessage());
    }

    @Test
    void testNoLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> 
            new Member("John", "", "1234567890", Member.Tier.BRONZE)
        );
        assertEquals("No last name provided.", exception.getMessage());
    }

    @Test
    void testInsufficientPointsException() {
        Member member = new Member("Jane", "Doe", "9876543210", Member.Tier.GOLD);
        Exception exception = assertThrows(InsufficientPointsException.class, () -> 
            member.redeemPoints(500)
        );
        assertEquals("Do not have enough points for purchase.", exception.getMessage());
    }
}
