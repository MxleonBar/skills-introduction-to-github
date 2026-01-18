package com.github.skills.dao;

import com.github.skills.model.Client;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * In-memory implementation of ClientDAO interface.
 * Uses a HashMap to store clients in memory.
 */
public class ClientDAOImpl implements ClientDAO {

    private final Map<Long, Client> clientStore = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    /**
     * Default constructor
     */
    public ClientDAOImpl() {
    }

    @Override
    public Client save(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        
        if (client.getId() == null) {
            client.setId(idGenerator.getAndIncrement());
        }
        
        clientStore.put(client.getId(), client);
        return client;
    }

    @Override
    public Optional<Client> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(clientStore.get(id));
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clientStore.values());
    }

    @Override
    public List<Client> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String searchName = name.toLowerCase();
        return clientStore.values().stream()
                .filter(client -> client.getName() != null && 
                        client.getName().toLowerCase().contains(searchName))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return Optional.empty();
        }
        
        return clientStore.values().stream()
                .filter(client -> email.equalsIgnoreCase(client.getEmail()))
                .findFirst();
    }

    @Override
    public Client update(Client client) {
        if (client == null || client.getId() == null) {
            throw new IllegalArgumentException("Client and client ID cannot be null");
        }
        
        if (!clientStore.containsKey(client.getId())) {
            throw new IllegalArgumentException("Client with ID " + client.getId() + " not found");
        }
        
        clientStore.put(client.getId(), client);
        return client;
    }

    @Override
    public boolean deleteById(Long id) {
        if (id == null) {
            return false;
        }
        return clientStore.remove(id) != null;
    }

    @Override
    public boolean existsById(Long id) {
        if (id == null) {
            return false;
        }
        return clientStore.containsKey(id);
    }

    @Override
    public long count() {
        return clientStore.size();
    }

    /**
     * Clears all clients from the store.
     * Useful for testing purposes.
     */
    public void clear() {
        clientStore.clear();
    }
}
