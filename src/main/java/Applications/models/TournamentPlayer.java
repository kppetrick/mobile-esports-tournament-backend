package Applications.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TournamentPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    private LocalDateTime createdAt;

    // Constructors, getters, and setters
}

