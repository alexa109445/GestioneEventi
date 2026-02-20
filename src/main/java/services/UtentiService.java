package services;

import entities.Utenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UtentiRepository;

import java.util.List;

@Service
public class UtentiService {
    @Autowired
    private UtentiRepository utentiRepo;

    public Utenti salvaUtente(Utenti nuovoUtente) {
        return utentiRepo.save(nuovoUtente);
    }

    public List<Utenti> listaUtenti() {
        return utentiRepo.findAll();
    }

    public Utenti trovaPerId(Long id) {
        return utentiRepo.findById(id).orElse(null);
    }
}

