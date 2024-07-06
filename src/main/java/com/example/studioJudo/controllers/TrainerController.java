package com.example.studioJudo.controllers;

import com.example.studioJudo.models.Client;
import com.example.studioJudo.models.Trainer;
import com.example.studioJudo.service.ClientService;
import com.example.studioJudo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping
    public List<Trainer> findAllTrainer() {
        return trainerService.findAllTrainer();
    }

    @PostMapping
    public Trainer saveTrainer(@RequestBody Trainer trainer) {
        return trainerService.saveTrainer(trainer);
    }

    @GetMapping("/{id}")
    public Optional<Trainer> findTrainerById(@PathVariable("id") Integer id) {
        return trainerService.findTrainerById(id);
    }

    @PutMapping("/{id}")
    public Trainer updateTrainer(@PathVariable("id") Integer id, @RequestBody Trainer trainer){
        return trainerService.updateTrainer(trainer);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainer(@PathVariable("id") Integer id){
        trainerService.deleteTrainer(id);
    }

}