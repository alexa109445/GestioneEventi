package alexandramanolache.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "utenti")
public class Utenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;
}
