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
public class PersonHasEventItem {
    @EmbeddedId
    PersonHasEventItemKey id;

    @ManyToOne
    @MapsId("PersonId")
    @JoinColumn(name = "PersonId")
    private Person person;

    @ManyToOne
    @MapsId("EventItemId")
    @JoinColumn(name = "EventItemId")
    private EventItem EventItem;

    @Column(name = "Amount", columnDefinition = "TINYINT(4)", nullable = false)
    private int amount;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Created", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime created;

    @Column(name = "Modified", columnDefinition = "DATETIME")
    private LocalDateTime modified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatedBy", columnDefinition = "CHAR(36)", nullable = false)
    private Person createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ModifiedBy", columnDefinition = "CHAR(36)")
    private Person modifiedBy;

    public PersonHasEventItem(PersonHasEventItemKey id, Person person, com.akademen.intra.com.akademen.intra.domain.EventItem eventItem, int amount, String description, LocalDateTime created, Person createdBy) {
        this.id = id;
        this.person = person;
        EventItem = eventItem;
        this.amount = amount;
        this.description = description;
        this.created = created;
        this.createdBy = createdBy;
    }

    public PersonHasEventItemKey getId() {
        return id;
    }

    public void setId(PersonHasEventItemKey id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public com.akademen.intra.com.akademen.intra.domain.EventItem getEventItem() {
        return EventItem;
    }

    public void setEventItem(com.akademen.intra.com.akademen.intra.domain.EventItem eventItem) {
        EventItem = eventItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Person getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Embeddable
    private static class PersonHasEventItemKey implements Serializable {
        @Column(name = "PersonId", columnDefinition = "CHAR(36)", nullable = false)
        String personId;
        @Column(name = "EventItemId", columnDefinition = "CHAR(36)", nullable = false)
        String eventItemId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PersonHasEventItemKey that = (PersonHasEventItemKey) o;
            return personId.equals(that.personId) &&
                eventItemId.equals(that.eventItemId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(personId, eventItemId);
        }
    }
}
