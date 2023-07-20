package org.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="Event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_ID")
    private Integer eventID;

    @JoinColumn (name = "venue_ID", referencedColumnName = "venue_ID")
    @ManyToOne
    private Venue venue;

    @JoinColumn (name = "event_type_ID", referencedColumnName = "event_type_ID")
    @ManyToOne
    private EventType eventType;

    @Column(name="event_description")
    private String eventDescription;

    @Column(name="event_name")
    private String eventName;

    @Column(name="start_date")
    private LocalDateTime startDate;


    @Column(name="end_date")
    private LocalDateTime endDate;

    public Event() {
    }

    public Event(Integer eventID, Venue venue, EventType eventType, String eventDescription, String eventName, LocalDateTime startDate, LocalDateTime endDate) {
        this.eventID = eventID;
        this.venue = venue;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer event_ID) {
        this.eventID = event_ID;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue_ID) {
        this.venue = venue_ID;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType event_type_ID) {
        this.eventType = event_type_ID;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String event_description) {
        this.eventDescription = event_description;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String event_name) {
        this.eventName = event_name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime start_date) {
        this.startDate = start_date;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime end_date) {
        this.endDate = end_date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_ID=" + eventID +
                ", venue_ID=" + venue +
                ", event_type_ID=" + eventType +
                ", event_description='" + eventDescription + '\'' +
                ", event_name='" + eventName + '\'' +
                ", start_date=" + startDate +
                ", end_date=" + endDate +
                '}';
    }
}
