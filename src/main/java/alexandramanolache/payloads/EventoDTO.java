package alexandramanolache.payloads;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EventoDTO {
    private String titolo;
    private String descrizione;
    private LocalDate data;
    private String luogo;
    private int postiTotali;
    private Long organizzatoreId;
}
