package com.akademen.intra.com.akademen.intra.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event {
    @ManyToMany(mappedBy = "events")
    Set<Person> persons;

    @OneToMany(mappedBy = "event")
    Set<PersonHasEvent> personHasEvents;

    @Id
    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private String id;

    @Column(name = "Name", columnDefinition = "VARCHAR(256)", nullable = false)
    private String name;

    @Column(name = "StartDate", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "EndDate", columnDefinition = "DATETIME")
    private LocalDateTime endDate;

    @Column(name = "RegistrationDueDate", columnDefinition = "DATETIME")
    private LocalDateTime registrationDueDate;

    @Column(name = "PaymentDueDate", columnDefinition = "DATETIME")
    private LocalDateTime paymentDueDate;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Price", columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double price;

    @Column(name = "Location", columnDefinition = "VARCHAR(256)", nullable = false)
    private String location;

    @Column(name = "IsAtClub", columnDefinition = "TINYINT(4)", nullable = false)
    private int isAtClub;

    @Column(name = "Type", columnDefinition = "TINYINT(4)", nullable = false)
    private int type;

    @Column(name = "IsExternal", columnDefinition = "TINYINT(4)", nullable = false)
    private int isExternal;

    @Column(name = "PaymentType", columnDefinition = "TINYINT(4)")
    private int paymentType;

    @Column(name = "Participant", columnDefinition = "TINYINT(4)")
    private int participant;

    @Column(name = "AvecAllowed", columnDefinition = "TINYINT(4)")
    private int avecAllowed;

    @Column(name = "PaymentInfo", columnDefinition = "TEXT")
    private String paymentInfo;

    @Column(name = "CanUsersViewRegistrations", columnDefinition = "TINYINT(4)")
    private int canUsersViewRegistrations;

    @Column(name = "CanUsersSetAllergies", columnDefinition = "TINYINT(4)")
    private int canUsersSetAllergies;

    @Column(name = "IsMapShown", columnDefinition = "TINYINT(4)")
    private int isMapShown;

    @Column(name = "Created", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime created;

    @Column(name = "Modified", columnDefinition = "DATETIME")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ResponsibleId", columnDefinition = "CHAR(36)", nullable = false)
    private Person responsible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatedBy", columnDefinition = "CHAR(36)", nullable = false)
    private Person createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModifiedBy", columnDefinition = "CHAR(36)")
    private Person modifiedBy;

    public Event() {
    }

    public Event(String id, String name, LocalDateTime startDate, LocalDateTime endDate, LocalDateTime registrationDueDate, LocalDateTime paymentDueDate, String description, double price, String location, int isAtClub, int type, int isExternal, int paymentType, int participant, int avecAllowed, String paymentInfo, int canUsersViewRegistrations, int canUsersSetAllergies, int isMapShown, LocalDateTime created, Person responsible, Person createdBy) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationDueDate = registrationDueDate;
        this.paymentDueDate = paymentDueDate;
        this.description = description;
        this.price = price;
        this.location = location;
        this.isAtClub = isAtClub;
        this.type = type;
        this.isExternal = isExternal;
        this.paymentType = paymentType;
        this.participant = participant;
        this.avecAllowed = avecAllowed;
        this.paymentInfo = paymentInfo;
        this.canUsersViewRegistrations = canUsersViewRegistrations;
        this.canUsersSetAllergies = canUsersSetAllergies;
        this.isMapShown = isMapShown;
        this.created = created;
        this.responsible = responsible;
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getRegistrationDueDate() {
        return registrationDueDate;
    }

    public void setRegistrationDueDate(LocalDateTime registrationDueDate) {
        this.registrationDueDate = registrationDueDate;
    }

    public LocalDateTime getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(LocalDateTime paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIsAtClub() {
        return isAtClub;
    }

    public void setIsAtClub(int isAtClub) {
        this.isAtClub = isAtClub;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(int isExternal) {
        this.isExternal = isExternal;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getParticipant() {
        return participant;
    }

    public void setParticipant(int participant) {
        this.participant = participant;
    }

    public int getAvecAllowed() {
        return avecAllowed;
    }

    public void setAvecAllowed(int avecAllowed) {
        this.avecAllowed = avecAllowed;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public int getCanUsersViewRegistrations() {
        return canUsersViewRegistrations;
    }

    public void setCanUsersViewRegistrations(int canUsersViewRegistrations) {
        this.canUsersViewRegistrations = canUsersViewRegistrations;
    }

    public int getCanUsersSetAllergies() {
        return canUsersSetAllergies;
    }

    public void setCanUsersSetAllergies(int canUsersSetAllergies) {
        this.canUsersSetAllergies = canUsersSetAllergies;
    }

    public int getIsMapShown() {
        return isMapShown;
    }

    public void setIsMapShown(int isMapShown) {
        this.isMapShown = isMapShown;
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

    public Person getResponsible() {
        return responsible;
    }

    public void setResponsible(Person responsible) {
        this.responsible = responsible;
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

    public Set<Person> getPersons() {
        return persons;
    }

    public Set<PersonHasEvent> getPersonHasEvents() {
        return personHasEvents;
    }
}
