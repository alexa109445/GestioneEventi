package alexandramanolache.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utenti utente;

    @ManyToOne
    @JoinColumn(name = "ecvento_id")
    private Evento evento;

}
