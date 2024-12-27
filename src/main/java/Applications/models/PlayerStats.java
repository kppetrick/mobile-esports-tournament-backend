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

    private Integer matchesPlayed = 0;
    private Integer matchesWon = 0;
    private Integer matchesLost = 0;
    private Integer totalDamage = 0;
    private Integer totalKills = 0;
    private Integer rankingPoints = 0;
    private LocalDateTime createdAt;

    // Getters and setters...
}

