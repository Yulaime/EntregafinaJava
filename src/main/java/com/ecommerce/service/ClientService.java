package com.ecommerce.service;

import com.ecommerce.entity.Client;
import com.ecommerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client updateClient(Long id, Client client) {
        Client existingClient = clientRepository.findById(id).orElse(null);
        if (existingClient != null) {
            existingClient.setName(client.getName());
            existingClient.setLastname(client.getLastname());
            existingClient.setDocnumber(client.getDocnumber());
            existingClient.setEmail(client.getEmail());
            existingClient.setAge(client.getAge());
            return clientRepository.save(existingClient);
        }
        return null;
    }
}
