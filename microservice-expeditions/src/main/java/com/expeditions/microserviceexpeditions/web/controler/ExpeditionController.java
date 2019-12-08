package com.expeditions.microserviceexpeditions.web.controler;

import com.expeditions.microserviceexpeditions.dao.ExpeditionDao;
import com.expeditions.microserviceexpeditions.model.Expedition;
import com.expeditions.microserviceexpeditions.web.exceptions.ExpeditionCreationException;
import com.expeditions.microserviceexpeditions.web.exceptions.ExpeditionNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    private ExpeditionDao expeditionDao;

    @PostMapping(value = "/expeditions")
    public ResponseEntity<Expedition> creerExpedition(@RequestBody Expedition expedition){

        Expedition nouvellExpedition = expeditionDao.save(expedition);

        if(nouvellExpedition == null) throw new ExpeditionCreationException("Impossible d'ajouter cette expedition");

        return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
    }

    @GetMapping(value = "/expeditions/{id}")
    public Optional<Expedition> recupererUneExpedition(@PathVariable int id){

        Optional<Expedition> expedition = expeditionDao.findById(id);
        if(!expedition.isPresent()) throw new ExpeditionNotFoundException("Cette expedition n'existe pas");
        return expedition;
    }

    @PutMapping(value = "/expeditions")
    public void updateExpedition(@RequestBody Expedition expedition) {

        //Vérifier qu'elle existe bien
        Optional<Expedition> expeditionEnBase = expeditionDao.findById(expedition.getId());

        //Si n'existe pas,on retourne une Exception
        if(!expeditionEnBase.isPresent()) throw new ExpeditionNotFoundException("Cette expedition n'existe pas");

        //Update
        expeditionDao.save(expedition);
    }
    }
