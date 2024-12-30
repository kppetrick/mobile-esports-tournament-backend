package Applications.services;

import Applications.dto.UserDto;
import Applications.models.User;
import Applications.repositories.UserRepository;
import Applications.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordUtils passwordUtils; // Inject PasswordUtils

    public void registerUser(UserDto userDto) {
        // Hash the raw password
        String hashedPassword = passwordUtils.hashPassword(userDto.getPassword());

        // Create and populate the User entity
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPasswordHash(hashedPassword); // Use the hashed password here
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        // Save the user to the database
        userRepository.save(user);
    }
}


