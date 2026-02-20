package alexandramanolache.payloads;

import alexandramanolache.entities.Ruolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginDTO {
    private String username;
    private String password;
    private Ruolo ruolo;
}