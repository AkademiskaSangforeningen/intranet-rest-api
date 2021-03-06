package com.akademen.intra.com.akademen.intra.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {
    @Id
    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private String id;

    @Column(name = "FirstName", columnDefinition = "VARCHAR(64)", nullable = false)
    private String firstName;

    @Column(name = "LastName", columnDefinition = "VARCHAR(64)", nullable = false)
    private String lastName;

    @Column(name = "Voice", columnDefinition = "CHAR(2)")
    private String voice; // ENUM?

    @Column(name = "Joined", columnDefinition = "VARCHAR(5)")
    private String joined;

    @Column(name = "Address", columnDefinition = "VARCHAR(128)")
    private String address;

    @Column(name = "PostalCode", columnDefinition = "VARCHAR(64)")
    private String postalCode;

    @Column(name = "City", columnDefinition = "VARCHAR(64)")
    private String city;

    @Column(name = "CountryId", columnDefinition = "CHAR(2)")
    private String countryId;

    @Column(name = "Phone", columnDefinition = "VARCHAR(64)")
    private String phone;

    @Column(name = "Email", columnDefinition = "VARCHAR(64)")
    private String email;

    @Column(name = "Allergies", columnDefinition = "VARCHAR(256)")
    private String allergies;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Status", columnDefinition = "TINYINT(4)", nullable = false)
    private int status;

    @Column(name = "UserRights", columnDefinition = "INT(10)", nullable = false)
    private int userRights;

    @Column(name = "Password", columnDefinition = "CHAR(60)", nullable = false)
    private String password;

    @Column(name = "Created", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime created;

    @Column(name = "Modified", columnDefinition = "DATETIME")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatedBy", columnDefinition = "CHAR(36)", nullable = false)
    @JsonIgnore
    private Person createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModifiedBy", columnDefinition = "CHAR(36)")
    @JsonIgnore
    private Person modifiedBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    @JsonIgnore
    private List<Transaction> transactions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "PersonHasEvent", joinColumns = @JoinColumn(name = "PersonId"), inverseJoinColumns = @JoinColumn(name = "EventId"))
    @JsonIgnore
    Set<Event> events;

    @OneToMany(mappedBy = "person")
    @JsonIgnore
    Set<PersonHasEvent> personHasEvents;

    public Person() {
    }

    public Person(String id, String firstName, String lastName, String voice, String joined, String address, String postalCode, String city, String countryId, String phone, String email, String allergies, String description, int status, int userRights, String password, LocalDateTime created, Person createdBy) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.voice = voice;
        this.joined = joined;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.countryId = countryId;
        this.phone = phone;
        this.email = email;
        this.allergies = allergies;
        this.description = description;
        this.status = status;
        this.userRights = userRights;
        this.password = password;
        this.created = created;
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getJoined() {
        return joined;
    }

    public void setJoined(String joined) {
        this.joined = joined;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserRights() {
        return userRights;
    }

    public void setUserRights(int userRights) {
        this.userRights = userRights;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public Person getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<PersonHasEvent> getPersonHasEvents() {
        return personHasEvents;
    }

    public void setPersonHasEvents(Set<PersonHasEvent> personHasEvents) {
        this.personHasEvents = personHasEvents;
    }
}
