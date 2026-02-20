package alexandramanolache.payloads;

import alexandramanolache.entities.Ruolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UtenteDTO {
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Ruolo ruolo;
}