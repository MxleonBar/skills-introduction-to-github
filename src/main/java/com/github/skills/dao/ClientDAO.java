package com.github.skills.dao;

import com.github.skills.model.Client;
import java.util.List;
import java.util.Optional;

/**
 * Data Access Object (DAO) interface for Client entity.
 * Defines CRUD operations for managing client data.
 */
public interface ClientDAO {

    /**
     * Saves a new client or updates an existing one
     *
     * @param client the client to save
     * @return the saved client with generated ID if new
     */
    Client save(Client client);

    /**
     * Finds a client by their ID
     *
     * @param id the client ID
     * @return an Optional containing the client if found, empty otherwise
     */
    Optional<Client> findById(Long id);

    /**
     * Retrieves all clients
     *
     * @return a list of all clients
     */
    List<Client> findAll();

    /**
     * Finds clients by name (case-insensitive partial match)
     *
     * @param name the name to search for
     * @return a list of clients matching the name
     */
    List<Client> findByName(String name);

    /**
     * Finds a client by email
     *
     * @param email the email to search for
     * @return an Optional containing the client if found, empty otherwise
     */
    Optional<Client> findByEmail(String email);

    /**
     * Updates an existing client
     *
     * @param client the client with updated information
     * @return the updated client
     */
    Client update(Client client);

    /**
     * Deletes a client by their ID
     *
     * @param id the client ID to delete
     * @return true if the client was deleted, false if not found
     */
    boolean deleteById(Long id);

    /**
     * Checks if a client exists by ID
     *
     * @param id the client ID
     * @return true if the client exists, false otherwise
     */
    boolean existsById(Long id);

    /**
     * Counts the total number of clients
     *
     * @return the total count of clients
     */
    long count();
}
