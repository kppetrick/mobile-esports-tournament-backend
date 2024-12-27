package Applications.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "streaming_links")
public class StreamingLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private Match match;

    private String streamUrl;
    private LocalDateTime createdAt;

    // Getters and setters...
}

