package alexandramanolache.services;

import alexandramanolache.entities.Evento;
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
        Utenti organizzatore = utentiService.trovaPerId(body.getOrganizzatoreId());
        if (organizzatore == null) {
            throw new RuntimeException("Errore: Organizzatore non trovato con ID: " + body.getOrganizzatoreId());
        }
        Evento nuovoEvento = new Evento();
        nuovoEvento.setTitolo(body.getTitolo());
        nuovoEvento.setDescrizione(body.getDescrizione());
        nuovoEvento.setData(body.getData());
        nuovoEvento.setLuogo(body.getLuogo());
        nuovoEvento.setPostiTotali(body.getPostiTotali());

        nuovoEvento.setOrganizzatore(organizzatore);
        return eventoRepo.save(nuovoEvento);

    }


}