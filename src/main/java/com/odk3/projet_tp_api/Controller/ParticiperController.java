package com.odk3.projet_tp_api.Controller;

import com.odk3.projet_tp_api.Service.ParticiperService;
import com.odk3.projet_tp_api.model.Participer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("participer")
public class ParticiperController {

    @Autowired // injection de donnée
    ParticiperService participerService;

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterParticiper(@RequestBody Participer participer) {
        Participer verifParticiper = participerService.creerParticiper(participer);
        if (verifParticiper != null) {
            return new ResponseEntity<>(verifParticiper, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("existe pas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public List<Participer> listParticiper() {
        return participerService.participerList();
    }

    @PutMapping("/modifier")
    public ResponseEntity<Object> modifierParticiper(@RequestBody Participer participer) {
        Participer verifParticiper = participerService.modifierParticiper(participer);
        if (verifParticiper != null) {
            return new ResponseEntity<>(verifParticiper, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("existe pas", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/supprimer")
    public ResponseEntity<String> supprimerParticiper(@RequestBody  Participer participer) {
        String message = participerService.supprimerParticiper(participer);

        if (message.equals("Sussès")) {
            return new ResponseEntity<>("Suppression avec succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT found", HttpStatus.NOT_FOUND);
        }
    }
}
