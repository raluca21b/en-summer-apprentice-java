package org.example.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RequestOrderDTO implements Serializable {
    private Integer eventID;
    private Integer ticketCategoryID;
    private Integer numberOfTickets;

    public RequestOrderDTO() {
    }

    public RequestOrderDTO(Integer eventID, Integer ticketCategoryID, Integer numberOfTickets) {
        this.eventID = eventID;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
    }

    public Integer getEventID() {
        return eventID;
    }

    public void setEventID(Integer eventID) {
        this.eventID = eventID;
    }

    public Integer getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Integer ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "RequestOrderDTO{" +
                "eventID=" + eventID +
                ", ticketCategoryID=" + ticketCategoryID +
                ", numberOfTickets=" + numberOfTickets +
                '}';
    }
}
