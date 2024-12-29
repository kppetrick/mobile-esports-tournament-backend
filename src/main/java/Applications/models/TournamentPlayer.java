package Applications.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tournament_players")
public class TournamentPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToMany(mappedBy = "players") // If you want to map both ways
    private List<Tournament> tournaments;

    // Add other necessary fields such as 'team_name', 'score', 'rank', etc. depending on the requirements

    // Getters and setters...
}


