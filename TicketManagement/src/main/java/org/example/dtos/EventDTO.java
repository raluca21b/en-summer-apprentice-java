package org.example.dtos;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class EventDTO implements Serializable {

    private Integer eventID;
    private VenueDTO venueDTO;
    private String eventType;
    private String eventDescription;
    private String eventName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<TicketCategoryDTO> ticketsCategory;

    public EventDTO() {
    }

    public EventDTO(Integer eventID, VenueDTO venueDTO, String eventType, String eventDescription,
                    String eventName, LocalDateTime startDate, LocalDateTime endDate, List<TicketCategoryDTO> ticketsCategory) {
        this.eventID = eventID;
        this.venueDTO = venueDTO;
        this.eventType = eventType;
        this.eventDescription = eventDescription;
        this.eventName = eventName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketsCategory = ticketsCategory;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public VenueDTO getVenueDTO() {
        return venueDTO;
    }

    public void setVenueDTO(VenueDTO venueDTO) {
        this.venueDTO = venueDTO;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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

    public List<TicketCategoryDTO> getTicketsCategory() {
        return ticketsCategory;
    }

    public void setTicketsCategory(List<TicketCategoryDTO> ticketsCategory) {
        this.ticketsCategory = ticketsCategory;
    }


    @Override
    public String toString() {
        return "EventDTO{" +
                "eventID=" + eventID +
                ", venue=" + venueDTO +
                ", eventType='" + eventType + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventName='" + eventName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", ticketsCategory=" + ticketsCategory +
                '}';
    }
}
