package alexandramanolache.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "eventi")
@Getter
@Setter
@NoArgsConstructor

public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int postiTotali;


    @ManyToOne
    @JoinColumn(name = "organizzatore_id")
    private Utenti organizzatore;
}
