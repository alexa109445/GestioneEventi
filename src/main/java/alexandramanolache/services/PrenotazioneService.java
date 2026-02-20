package alexandramanolache.services;


import alexandramanolache.entities.Evento;
import alexandramanolache.entities.Prenotazione;
import alexandramanolache.entities.Utenti;
import alexandramanolache.payloads.PrenotazioneDTO;
import alexandramanolache.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepo;
    @Autowired
    private UtentiService utentiService;
    @Autowired
    private EventoService eventoService;

    public Prenotazione SalvaPrenotazione(PrenotazioneDTO body) {
        Long idUtente = body.getUtenteId();
        Long idEvento = body.getEventoId();

        Utenti utenteTrovato = utentiService.trovaPerId(idUtente);
        Evento eventoTrovato = eventoService.trovaPerId(idEvento);

        if (utenteTrovato == null) {
            System.out.println("L'utente con questo ID non esiste!");
            return null;
        }
        Prenotazione nuovaP = new Prenotazione();
        nuovaP.setDataPrenotazione(LocalDate.now());
        nuovaP.setUtente(utenteTrovato);
        nuovaP.setEvento(eventoTrovato);
        return prenotazioneRepo.save(nuovaP);
    }

}
