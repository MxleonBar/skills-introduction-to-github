package com.github.skills;

import com.github.skills.dao.ClientDAO;
import com.github.skills.dao.ClientDAOImpl;
import com.github.skills.model.Client;
import java.util.List;
import java.util.Optional;

/**
 * Example usage of Client model and ClientDAO.
 * Demonstrates basic CRUD operations.
 */
public class ClientExample {

    public static void main(String[] args) {
        // Create DAO instance
        ClientDAO clientDAO = new ClientDAOImpl();

        // Create and save clients
        Client client1 = new Client(null, "John Doe", "john.doe@example.com", "555-1234", "123 Main St");
        Client client2 = new Client(null, "Jane Smith", "jane.smith@example.com", "555-5678", "456 Oak Ave");
        
        client1 = clientDAO.save(client1);
        client2 = clientDAO.save(client2);

        System.out.println("Saved clients:");
        System.out.println(client1);
        System.out.println(client2);

        // Find client by ID
        Optional<Client> foundClient = clientDAO.findById(client1.getId());
        foundClient.ifPresent(c -> System.out.println("\nFound by ID: " + c));

        // Find all clients
        List<Client> allClients = clientDAO.findAll();
        System.out.println("\nAll clients (" + allClients.size() + "):");
        allClients.forEach(System.out::println);

        // Find by name
        List<Client> johnClients = clientDAO.findByName("John");
        System.out.println("\nClients with 'John' in name:");
        johnClients.forEach(System.out::println);

        // Find by email
        Optional<Client> clientByEmail = clientDAO.findByEmail("jane.smith@example.com");
        clientByEmail.ifPresent(c -> System.out.println("\nFound by email: " + c));

        // Update client
        client1.setPhone("555-9999");
        clientDAO.update(client1);
        System.out.println("\nUpdated client: " + clientDAO.findById(client1.getId()).orElse(null));

        // Check if client exists
        System.out.println("\nClient with ID 1 exists: " + clientDAO.existsById(1L));

        // Count clients
        System.out.println("Total clients: " + clientDAO.count());

        // Delete client
        boolean deleted = clientDAO.deleteById(client2.getId());
        System.out.println("\nDeleted client 2: " + deleted);
        System.out.println("Total clients after deletion: " + clientDAO.count());
    }
}
