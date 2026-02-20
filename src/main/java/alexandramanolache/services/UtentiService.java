package alexandramanolache.services;

import alexandramanolache.entities.Utenti;
import alexandramanolache.payloads.LoginDTO;
import alexandramanolache.payloads.UtenteDTO;
import alexandramanolache.repositories.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtentiService {

    @Autowired
    private UtentiRepository utentiRepo;

    @Autowired
    private PasswordEncoder bcrypt;

    public String effettuaLogin(LoginDTO loginDTO) {

        String usernameInserito = loginDTO.getUsername();
        String passwordInserita = loginDTO.getPassword();

        Utenti utenteTrovato = utentiRepo.findByUsername(usernameInserito).orElse(null);

        if (utenteTrovato == null) {
            return "Errore: Utente non trovato nel database!";
        }

        if (!utenteTrovato.getPassword().equals(passwordInserita)) {
            return "Errore: La password è sbagliata!";
        }

        return "Login effettuato con successo! Benvenuto " + utenteTrovato.getUsername();
    }


    public Utenti salvaUtente(UtenteDTO body) {

        Utenti nuovoUtente = new Utenti();

        nuovoUtente.setUsername(body.getUsername());
        nuovoUtente.setNome(body.getNome());
        nuovoUtente.setCognome(body.getCognome());
        nuovoUtente.setEmail(body.getEmail());

        String passwordCriptata = bcrypt.encode(body.getPassword());
        nuovoUtente.setPassword(passwordCriptata);

        nuovoUtente.setRuolo(body.getRuolo());

        return utentiRepo.save(nuovoUtente);
    }

    public List<Utenti> listaUtenti() {
        return utentiRepo.findAll();
    }

    public Utenti trovaPerId(Long id) {
        return utentiRepo.findById(id).orElse(null);
    }
}