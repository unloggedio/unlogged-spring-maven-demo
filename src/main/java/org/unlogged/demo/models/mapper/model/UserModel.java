package org.unlogged.demo.models.mapper.model;

import java.util.ArrayList;

public class UserModel {
    private Long id;
    private String username;
    private AddressModel address;
    private ContactInformation contactInformation = new ContactInformation(new ArrayList<>(), new ArrayList<>());

    public UserModel(Long id, String username, AddressModel address, ContactInformation contactInformation) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.contactInformation = contactInformation;
    }

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }
}
