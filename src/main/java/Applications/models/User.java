package Applications.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    // === Primary Key ===
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // === User Details ===
    private String username;
    private String email;

    @Column(name = "password_hash") // Ensures the field maps to password_hash in the DB
    private String password; // For non-OAuth2 users

    // === OAuth2 Fields ===
    private String oauth2Provider;        // e.g., Google, Facebook
    private String oauth2ProviderId;     // Provider-specific user ID

    // === Relationships ===
    @OneToMany(mappedBy = "user")
    private List<Tournament> tournaments;

    @ManyToMany
    @JoinTable(
            name = "user_tournaments",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    private Set<Tournament> tournamentsParticipated;

    // === Constructors ===
    public User() {
        // Default constructor for JPA
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // === Getters and Setters ===
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOauth2Provider() {
        return oauth2Provider;
    }

    public void setOauth2Provider(String oauth2Provider) {
        this.oauth2Provider = oauth2Provider;
    }

    public String getOauth2ProviderId() {
        return oauth2ProviderId;
    }

    public void setOauth2ProviderId(String oauth2ProviderId) {
        this.oauth2ProviderId = oauth2ProviderId;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Set<Tournament> getTournamentsParticipated() {
        return tournamentsParticipated;
    }

    public void setTournamentsParticipated(Set<Tournament> tournamentsParticipated) {
        this.tournamentsParticipated = tournamentsParticipated;
    }
}
