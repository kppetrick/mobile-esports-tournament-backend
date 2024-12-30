package Applications.services;

import Applications.models.User;
import Applications.repositories.UserRepository;
import Applications.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordUtils passwordUtils; // Inject PasswordUtils

    public AuthenticationService(UserRepository userRepository, PasswordUtils passwordUtils) {
        this.userRepository = userRepository;
        this.passwordUtils = passwordUtils;
    }

    public void authenticate(String username, String rawPassword) {
        // Retrieve user by username
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Verify the password
        if (!passwordUtils.verifyPassword(rawPassword, user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}


