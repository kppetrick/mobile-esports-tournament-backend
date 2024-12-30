package Applications.utilTests;

import Applications.util.PasswordUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilsTests {

    private final PasswordUtils passwordUtils = new PasswordUtils();

    @Test
    void testHashPassword() {
        String rawPassword = "test123";
        String hashedPassword = passwordUtils.hashPassword(rawPassword);

        assertNotNull(hashedPassword);
        assertTrue(passwordUtils.verifyPassword(rawPassword , hashedPassword));
    }

    @Test
    void testVerifyPasswordFails() {
        String rawPassword = "test123";
        String wrongPassword = "wrong123";
        String hashedPassword = passwordUtils.hashPassword(rawPassword);

        assertFalse(passwordUtils.verifyPassword(wrongPassword, hashedPassword));
    }
}
