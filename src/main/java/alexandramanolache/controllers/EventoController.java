package alexandramanolache.controllers;


import alexandramanolache.entities.Evento;
import alexandramanolache.payloads.EventoDTO;
import alexandramanolache.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento creaEvento(@RequestBody EventoDTO body) {
        return eventoService.salvaEvento((body));
    }
}
