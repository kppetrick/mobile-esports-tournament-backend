package Applications.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String adminPassword = encoder.encode("admin123");
        String organizerPassword = encoder.encode("org123");
        String competitorPassword = encoder.encode("comp123");

        System.out.println("Admin Password Hash: " + adminPassword);
        System.out.println("Organizer Password Hash: " + organizerPassword);
        System.out.println("Competitor Password Hash: " + competitorPassword);
    }
}
