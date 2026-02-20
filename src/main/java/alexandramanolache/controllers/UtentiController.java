package alexandramanolache.controllers;

import alexandramanolache.entities.Utenti;
import alexandramanolache.payloads.LoginDTO;
import alexandramanolache.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")

public class UtentiController {
    @Autowired
    private UtentiService utentiService;

    @PostMapping("/registrazione")
    public Utenti registraNuovo(@RequestBody Utenti utenteDaSalvare) {
        return utentiService.salvaUtente(utenteDaSalvare);
    }

    @GetMapping("/lista")
    public List<Utenti> vediTutti() {
        return utentiService.listaUtenti();
    }

    @PostMapping("/login")
    public String loginUtente(@RequestBody LoginDTO loginDTO) {
        return utentiService.effettuaLogin(loginDTO);
    }
}
