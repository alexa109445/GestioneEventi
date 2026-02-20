package alexandramanolache.services;

import alexandramanolache.entities.Utenti;
import alexandramanolache.payloads.LoginDTO;
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

    public Utenti salvaUtente(Utenti nuovoUtente) {
        String passwordCriptata = bcrypt.encode(nuovoUtente.getPassword());
        nuovoUtente.setPassword(passwordCriptata);

        return utentiRepo.save(nuovoUtente);
    }

    public List<Utenti> listaUtenti() {
        return utentiRepo.findAll();
    }

//    public Utenti trovaPerId(Long id) {
//        return utentiRepo.findById(id).orElse(null);
//    }
}