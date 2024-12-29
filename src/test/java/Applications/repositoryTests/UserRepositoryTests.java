package Applications.repositoryTests;

import Applications.models.User;
import Applications.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional  // Ensures rollback of database changes after each test
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    // Insert the users into the database before each test to ensure data is available
    @BeforeEach
    public void setUp() {
        userRepository.save(new User("testuser", "testuser@example.com", "hashedpassword123"));
        userRepository.save(new User("johndoe", "johndoe@example.com", "hashedpassword456"));
        userRepository.save(new User("janedoe", "janedoe@example.com", "hashedpassword789"));
    }

    @Test
    public void testFindByEmail() {
        // Find a user by email
        Optional<User> foundUser = userRepository.findByEmail("johndoe@example.com");

        // Assert the user is found and details match
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("johndoe@example.com");
    }

    @Test
    public void testFindByUsername() {
        // Find a user by username
        Optional<User> foundUser = userRepository.findByUsername("johndoe");

        // Assert the user is found and details match
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo("johndoe");
        assertThat(foundUser.get().getEmail()).isEqualTo("johndoe@example.com");
    }

    @Test
    public void testSaveUser() {
        // Save and verify the user without affecting future tests
        User testUser = new User("newuser", "newuser@example.com", "hashedpassword000");
        User savedUser = userRepository.save(testUser);

        // Verify the user is saved and fields match
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
        assertThat(savedUser.getUsername()).isEqualTo("newuser");
        assertThat(savedUser.getEmail()).isEqualTo("newuser@example.com");
    }

    @Test
    public void testDeleteUser() {
        // Find and delete an existing user
        Optional<User> userToDelete = userRepository.findByEmail("janedoe@example.com");
        assertThat(userToDelete).isPresent();

        // Delete the user
        userRepository.delete(userToDelete.get());

        // Assert the user is no longer found
        Optional<User> deletedUser = userRepository.findByEmail("janedoe@example.com");
        assertThat(deletedUser).isNotPresent();
    }

    @Test
    public void testUserNotFound() {
        // Try to find a user that does not exist
        Optional<User> foundUser = userRepository.findByEmail("nonexistent@example.com");

        // Assert that no user is found
        assertThat(foundUser).isNotPresent();
    }
}
