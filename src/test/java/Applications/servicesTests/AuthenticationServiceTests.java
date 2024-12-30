package Applications.servicesTests;

import Applications.models.User;
import Applications.repositories.UserRepository;
import Applications.services.AuthenticationService;
import Applications.util.PasswordUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enable Mockito extension
public class AuthenticationServiceTests {

    @Mock
    private UserRepository userRepository; // Mock the repository

    @Mock
    private PasswordUtils passwordUtils; // Mock the PasswordUtils

    @InjectMocks
    private AuthenticationService authenticationService; // Inject mocks into the service

    @Test
    void testAuthenticateSuccess() {
        String username = "admin_user1";
        String rawPassword = "admin123";
        String hashedPassword = "$2a$10$hashedPassword"; // Example hashed password

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(hashedPassword);

        // Stub methods
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user)); // Simulate user found
        when(passwordUtils.verifyPassword(rawPassword, hashedPassword)).thenReturn(true); // Simulate password match

        // Test authenticate method
        assertDoesNotThrow(() -> authenticationService.authenticate(username, rawPassword));
        verify(userRepository, times(1)).findByUsername(username); // Verify repository interaction
        verify(passwordUtils, times(1)).verifyPassword(rawPassword, hashedPassword); // Verify password check
    }

    @Test
    void testAuthenticateFailure() {
        String username = "non_existent_user";
        String rawPassword = "fakepassword123";

        // Stub methods
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty()); // Simulate user not found

        // Test authenticate method
        Exception exception = assertThrows(RuntimeException.class, () -> authenticationService.authenticate(username, rawPassword));
        assertEquals("User not found", exception.getMessage());

        verify(userRepository, times(1)).findByUsername(username); // Verify repository interaction
        verifyNoInteractions(passwordUtils); // Ensure no password checks are performed
    }

    @Test
    void testAuthenticateInvalidPassword() {
        String username = "testUser";
        String rawPassword = "wrong123";
        String hashedPassword = "$2a$10$hashedPassword"; // Example hashed password

        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(hashedPassword);

        // Stub methods
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user)); // Simulate user found
        when(passwordUtils.verifyPassword(rawPassword, hashedPassword)).thenReturn(false); // Simulate password mismatch

        // Test authenticate method
        Exception exception = assertThrows(RuntimeException.class, () -> authenticationService.authenticate(username, rawPassword));
        assertEquals("Invalid credentials", exception.getMessage());

        verify(userRepository, times(1)).findByUsername(username); // Verify repository interaction
        verify(passwordUtils, times(1)).verifyPassword(rawPassword, hashedPassword); // Verify password check
    }
}
