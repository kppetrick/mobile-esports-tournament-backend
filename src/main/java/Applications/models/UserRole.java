package Applications.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String roleName;

    private LocalDateTime createdAt;

    // Constructors, getters, and setters
}

