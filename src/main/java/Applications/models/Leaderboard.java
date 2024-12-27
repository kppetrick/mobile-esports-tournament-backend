package Applications.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "leaderboard")
public class Leaderboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    private Integer rank;
    private Integer points = 0;
    private LocalDateTime createdAt;

    // Getters and setters...
}

