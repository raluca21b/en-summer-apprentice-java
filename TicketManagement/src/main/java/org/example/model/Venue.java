package org.example.model;


import javax.persistence.*;

@Entity
@Table(name="Venue")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="venue_ID")
    private Integer venueID;

    @Column(name="location")
    private String location;

    @Column(name="type")
    private String type;

    @Column(name="capacity")
    private Integer capacity;

    public Venue() {
    }

    public Venue(Integer venueID, String location, String type, Integer capacity) {
        this.venueID = venueID;
        this.location = location;
        this.type = type;
        this.capacity = capacity;
    }

    public Integer getVenueID() {
        return venueID;
    }

    public void setVenueID(Integer venueID) {
        this.venueID = venueID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueID=" + venueID +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
