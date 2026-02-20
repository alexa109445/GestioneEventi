package alexandramanolache.controllers;

import alexandramanolache.entities.Prenotazione;
import alexandramanolache.payloads.PrenotazioneDTO;
import alexandramanolache.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("/crea")
    public Prenotazione crea(@RequestBody PrenotazioneDTO body) {
        return prenotazioneService.SalvaPrenotazione(body);
    }
}