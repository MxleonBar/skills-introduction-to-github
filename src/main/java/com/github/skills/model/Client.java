package com.github.skills.model;

/**
 * Client model class representing a client entity.
 * This class contains basic client information.
 */
public class Client {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    /**
     * Default constructor
     */
    public Client() {
    }

    /**
     * Constructor with all fields
     *
     * @param id      the client ID
     * @param name    the client name
     * @param email   the client email
     * @param phone   the client phone number
     * @param address the client address
     */
    public Client(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Gets the client ID
     *
     * @return the client ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the client ID
     *
     * @param id the client ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the client name
     *
     * @return the client name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the client name
     *
     * @param name the client name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the client email
     *
     * @return the client email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the client email
     *
     * @param email the client email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the client phone number
     *
     * @return the client phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the client phone number
     *
     * @param phone the client phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the client address
     *
     * @return the client address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the client address
     *
     * @param address the client address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id != null ? id.equals(client.id) : client.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
