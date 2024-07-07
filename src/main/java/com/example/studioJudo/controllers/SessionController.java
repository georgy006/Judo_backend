package com.example.studioJudo.controllers;

import com.example.studioJudo.models.Session;
import com.example.studioJudo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> findAllSession() {
        return sessionService.findAllSession();
    }

    @PostMapping
    public Session saveSession(@RequestBody Session session) {
        return sessionService.saveSession(session);
    }

    @GetMapping("/{id}")
    public Optional<Session> findSessionById(@PathVariable("id") Integer id) {
        return sessionService.findSessionById(id);
    }

    @PutMapping("/{id}")
    public Session updateSession(@RequestBody Session session) {
        return sessionService.updateSession(session);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable("id") Integer id) {
        sessionService.deleteSession(id);
    }

}
