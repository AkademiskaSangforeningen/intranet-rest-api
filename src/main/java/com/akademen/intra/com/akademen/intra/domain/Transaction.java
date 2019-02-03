package com.akademen.intra.com.akademen.intra.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {
    @Id
    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private String id;

    @Column(name = "TransactionDate", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime transactionDate;

    @Column(name = "Amount", columnDefinition = "DECIMAL(10,2)", nullable = false)
    private double amount;

    @Column(name = "Description", columnDefinition = "VARCHAR(256)")
    private String description;

    @Column(name = "Created", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime created;

    @Column(name = "Modified", columnDefinition = "DATETIME")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PersonId", columnDefinition = "CHAR(36)", nullable = false)
    private Person person;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EventId", columnDefinition = "CHAR(36)")
    private Event event;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatedBy", columnDefinition = "CHAR(36)", nullable = false)
    private Person createdBy;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModifiedBy", columnDefinition = "CHAR(36)")
    private Person modifiedBy;

    public Transaction() {
    }

    public Transaction(String id, Person person, Event event, LocalDateTime transactionDate, double amount, String description, LocalDateTime created, Person createdBy) {
        this.id = id;
        this.person = person;
        this.event = event;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.description = description;
        this.created = created;
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
}
