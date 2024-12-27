package Applications.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prizes")
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    private BigDecimal prizeAmount;
    private String prizeType;
    private Boolean distributed = false;
    private LocalDateTime createdAt;

    // Getters and setters...
}

