package com.example.studioJudo.controllers;

import com.example.studioJudo.models.Client;
import com.example.studioJudo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") // обязательно чтобы связать с фронтом!
@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAllClient() {
        return clientService.findAllClient();
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/{id}")
    public Optional<Client> findClientById(@PathVariable("id") Integer id) {
        return clientService.findClientById(id);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") Integer id, @RequestBody Client client){
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") Integer id){
        clientService.deleteClient(id);
    }

}
