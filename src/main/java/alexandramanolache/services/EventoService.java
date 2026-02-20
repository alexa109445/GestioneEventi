package alexandramanolache.services;

import alexandramanolache.entities.Evento;
import alexandramanolache.entities.Ruolo;
import alexandramanolache.entities.Utenti;
import alexandramanolache.payloads.EventoDTO;
import alexandramanolache.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepo;

    @Autowired
    private UtentiService utentiService;

    public Evento salvaEvento(EventoDTO body) {
        Utenti utente = utentiService.trovaPerId(body.getOrganizzatoreId());

        if (utente == null) {
            return null;
        }

        if (utente.getRuolo() == Ruolo.ORGANIZZATORE) {
            Evento nuovo = new Evento();
            nuovo.setTitolo(body.getTitolo());
            nuovo.setDescrizione(body.getDescrizione());
            nuovo.setData(body.getData());
            nuovo.setLuogo(body.getLuogo());
            nuovo.setPostiTotali(body.getPostiTotali());
            nuovo.setOrganizzatore(utente);

            return eventoRepo.save(nuovo);
        } else {
            return null;
        }
    }

    public Evento trovaPerId(Long id) {
        return eventoRepo.findById(id).orElse(null);
    }

    public void eliminaEvento(Long id) {
        Evento eventoDaEliminare = trovaPerId(id);

        if (eventoDaEliminare != null) {
            eventoRepo.delete(eventoDaEliminare);
        }
    }

    public Evento modificaEvento(Long id, EventoDTO body) {
        Evento eventoEsistente = trovaPerId(id);

        if (eventoEsistente != null) {
            eventoEsistente.setTitolo(body.getTitolo());
            eventoEsistente.setDescrizione(body.getDescrizione());
            eventoEsistente.setData(body.getData());
            eventoEsistente.setLuogo(body.getLuogo());
            eventoEsistente.setPostiTotali(body.getPostiTotali());

            return eventoRepo.save(eventoEsistente);
        } else {
            return null;
        }
    }
}
