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
    public Transaction() {}

    public Transaction(String id, Person person, String eventId, LocalDateTime transactionDate, double amount, String description, LocalDateTime created, Person createdBy) {
        this.id = id;
        this.person = person;
        this.eventId = eventId;
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    @Id
    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private String id;
    @Column(name = "EventId", columnDefinition = "CHAR(34)")
    private String eventId;
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
    @JoinColumn(name = "PersonId")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatedBy", columnDefinition = "CHAR", nullable = false)
    private Person createdBy;

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModifiedBy", columnDefinition = "CHAR")
    private Person modifiedBy;

    public Person getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}


/*
  Id char(36) COLLATE utf8_swedish_ci NOT NULL,
  PersonId char(36) COLLATE utf8_swedish_ci NOT NULL,
  TransactionId char(36) COLLATE utf8_swedish_ci DEFAULT NULL,
  TransactionDate datetime NOT NULL,
  Amount decimal(10,2) NOT NULL,
  Description varchar(256) COLLATE utf8_swedish_ci NOT NULL,
  Created datetime NOT NULL,
  CreatedBy char(36) COLLATE utf8_swedish_ci NOT NULL,
  Modified datetime DEFAULT NULL,
  ModifiedBy char(36) COLLATE utf8_swedish_ci DEFAULT NULL,
  PRIMARY KEY (Id),
  UNIQUE KEY `PersonId_EventId` (`PersonId`,`EventId`),
  KEY CreatedBy (CreatedBy),
  KEY ModifiedBy (ModifiedBy)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;
 */