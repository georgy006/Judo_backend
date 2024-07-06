package com.example.studioJudo.service;

import com.example.studioJudo.models.Trainer;

import java.util.List;
import java.util.Optional;

public interface TrainerService {
    List<Trainer> findAllTrainer();
    Optional<Trainer> findTrainerById(Integer id);
    Trainer saveTrainer(Trainer trainer);
    Trainer updateTrainer(Trainer trainer);
    void deleteTrainer(Integer id);
}
