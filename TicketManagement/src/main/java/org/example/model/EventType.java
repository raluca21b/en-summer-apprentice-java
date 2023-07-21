package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name="EventType")
public class EventType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_type_ID")
    private Integer eventTypeID;

    @Column(name="event_type_name")
    private String eventTypeName;

    public EventType() {
    }

    public EventType(Integer event_type_ID, String eventTypeName) {
        this.eventTypeID = event_type_ID;
        this.eventTypeName = eventTypeName;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "eventTypeID=" + eventTypeID +
                ", eventTypeName='" + eventTypeName + '\'' +
                '}';
    }

    public Integer getEvent_type_ID() {
        return eventTypeID;
    }

    public void setEvent_type_ID(Integer eventTypeID) {
        this.eventTypeID = eventTypeID;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }
}
