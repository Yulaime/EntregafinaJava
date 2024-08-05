package com.ecommerce.controller;

import com.ecommerce.entity.Client;
import com.ecommerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PutMapping("/me/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}
