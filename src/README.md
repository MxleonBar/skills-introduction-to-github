# Client Model and DAO Implementation

This directory contains a Java implementation of a Client model class and Data Access Object (DAO) pattern.

## Structure

```
src/main/java/com/github/skills/
├── model/
│   └── Client.java           # Client model class
├── dao/
│   ├── ClientDAO.java        # DAO interface
│   └── ClientDAOImpl.java    # DAO implementation
└── ClientExample.java         # Example usage
```

## Components

### Client Model (`model/Client.java`)
A POJO (Plain Old Java Object) representing a client entity with the following properties:
- `id` (Long) - Unique identifier
- `name` (String) - Client name
- `email` (String) - Client email address
- `phone` (String) - Client phone number
- `address` (String) - Client address

Includes:
- Getters and setters for all properties
- Constructors (default and parameterized)
- `toString()`, `equals()`, and `hashCode()` methods

### ClientDAO Interface (`dao/ClientDAO.java`)
Defines CRUD (Create, Read, Update, Delete) operations:
- `save(Client)` - Save a new client
- `findById(Long)` - Find client by ID
- `findAll()` - Get all clients
- `findByName(String)` - Find clients by name
- `findByEmail(String)` - Find client by email
- `update(Client)` - Update existing client
- `deleteById(Long)` - Delete client by ID
- `existsById(Long)` - Check if client exists
- `count()` - Count total clients

### ClientDAOImpl (`dao/ClientDAOImpl.java`)
In-memory implementation using HashMap:
- Stores clients in memory
- Auto-generates IDs for new clients
- Provides all CRUD operations defined in the interface

## Compilation

To compile the code:

```bash
javac -d build src/main/java/com/github/skills/model/Client.java \
              src/main/java/com/github/skills/dao/ClientDAO.java \
              src/main/java/com/github/skills/dao/ClientDAOImpl.java \
              src/main/java/com/github/skills/ClientExample.java
```

## Running the Example

To run the example:

```bash
cd build
java com.github.skills.ClientExample
```

The example demonstrates:
- Creating and saving clients
- Finding clients by ID, name, and email
- Listing all clients
- Updating client information
- Deleting clients
- Checking existence and counting clients

## Usage Example

```java
// Create DAO instance
ClientDAO clientDAO = new ClientDAOImpl();

// Create and save a client
Client client = new Client(null, "John Doe", "john@example.com", "555-1234", "123 Main St");
client = clientDAO.save(client);

// Find by ID
Optional<Client> found = clientDAO.findById(client.getId());

// Update client
client.setPhone("555-9999");
clientDAO.update(client);

// Delete client
clientDAO.deleteById(client.getId());
```

## Notes

- This is an in-memory implementation suitable for learning and demonstration
- Data is not persisted between application runs
- For production use, consider implementing persistence with a database
- Thread safety: Current implementation uses HashMap; consider ConcurrentHashMap for multi-threaded environments
