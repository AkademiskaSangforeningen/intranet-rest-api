package com.akademen.intra.com.akademen.intra.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EventItem {
    @Id
    @Column(columnDefinition = "CHAR(36)", nullable = false)
    private String id;

    @Column(name = "Type", columnDefinition = "TINYINT(4)", nullable = false)
    private int type;

    @Column(name = "Caption", columnDefinition = "VARCHAR(256)", nullable = false)
    private String caption;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "MaxPcs", columnDefinition = "TINYINT(4)")
    private int macPcs;

    @Column(name = "Amount", columnDefinition = "DECIMAL(10,2)")
    private double amount;

    @Column(name = "PreSelected", columnDefinition = "TINYINT(4)")
    private int preSelected;

    @Column(name = "ShowForAvec", columnDefinition = "TINYINT(4)")
    private int showForAvec;

    @Column(name = "RowOrder", columnDefinition = "TINYINT(4)")
    private int rowOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EventId", columnDefinition = "CHAR(36)")
    private Event event;

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

    public EventItem() {
    }

    public EventItem(String id, int type, String caption, String description, int macPcs, double amount, int preSelected, int showForAvec, int rowOrder, Event event, LocalDateTime created, Person createdBy) {
        this.id = id;
        this.type = type;
        this.caption = caption;
        this.description = description;
        this.macPcs = macPcs;
        this.amount = amount;
        this.preSelected = preSelected;
        this.showForAvec = showForAvec;
        this.rowOrder = rowOrder;
        this.event = event;
        this.created = created;
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMacPcs() {
        return macPcs;
    }

    public void setMacPcs(int macPcs) {
        this.macPcs = macPcs;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPreSelected() {
        return preSelected;
    }

    public void setPreSelected(int preSelected) {
        this.preSelected = preSelected;
    }

    public int getShowForAvec() {
        return showForAvec;
    }

    public void setShowForAvec(int showForAvec) {
        this.showForAvec = showForAvec;
    }

    public int getRowOrder() {
        return rowOrder;
    }

    public void setRowOrder(int rowOrder) {
        this.rowOrder = rowOrder;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
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
}
