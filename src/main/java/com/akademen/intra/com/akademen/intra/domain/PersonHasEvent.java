package com.akademen.intra.com.akademen.intra.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PersonHasEvent {
    @EmbeddedId
    PersonHasEventKey id;

    @ManyToOne
    @MapsId("PersonId")
    @JoinColumn(name = "PersonId")
    private Person person;

    @ManyToOne
    @MapsId("EventId")
    @JoinColumn(name = "EventId")
    private Event event;

    @Column(name = "Status", columnDefinition = "TINYINT(4)", nullable = false)
    private int status;

    @Column(name = "PaymentType", columnDefinition = "TINYINT(4)")
    private int paymentType;

    @Column(name = "Unregistered", columnDefinition = "TINYINT(4)")
    private int unregistered;

    @Column(name = "Created", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime created;

    @Column(name = "Modified", columnDefinition = "DATETIME")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AvecPersonId", columnDefinition = "CHAR(36)")
    private Person avecPerson;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatedBy", columnDefinition = "CHAR(36)", nullable = false)
    private Person createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModifiedBy", columnDefinition = "CHAR(36)")
    private Person modifiedBy;

    public PersonHasEvent() {
    }

    public PersonHasEvent(PersonHasEventKey id, Person person, Event event, int status, int paymentType, int unregistered, LocalDateTime created, Person avecPerson, Person createdBy) {
        this.id = id;
        this.person = person;
        this.event = event;
        this.status = status;
        this.paymentType = paymentType;
        this.unregistered = unregistered;
        this.created = created;
        this.avecPerson = avecPerson;
        this.createdBy = createdBy;
    }

    public PersonHasEventKey getId() {
        return id;
    }

    public void setId(PersonHasEventKey id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getUnregistered() {
        return unregistered;
    }

    public void setUnregistered(int unregistered) {
        this.unregistered = unregistered;
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

    public Person getAvecPerson() {
        return avecPerson;
    }

    public void setAvecPerson(Person avecPerson) {
        this.avecPerson = avecPerson;
    }

    public Person getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Embeddable
    private static class PersonHasEventKey implements Serializable {
        @Column(name = "PersonId", columnDefinition = "CHAR(36)", nullable = false)
        String personId;
        @Column(name = "EventId", columnDefinition = "CHAR(36)", nullable = false)
        String eventId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonHasEventKey that = (PersonHasEventKey) o;
            return personId.equals(that.personId) &&
                eventId.equals(that.eventId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(personId, eventId);
        }
    }
}
