package Applications.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "player_stats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    // Fields like matches_played, matches_won, etc.
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;

    // Getters and setters...
}


