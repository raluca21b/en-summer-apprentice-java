package org.example.dtos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO implements Serializable {
    private int eventID;
    private LocalDateTime orderedAt;
    private int ticketCategoryID;
    private int numberOfTickets;
    private BigDecimal totalPrice;

    public OrderDTO() {
    }

    public OrderDTO(int eventID, int ticketCategoryID, int numberOfTickets) {
        this.eventID = eventID;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
    }

    public OrderDTO(int eventID, LocalDateTime orderedAt, int ticketCategoryID, int numberOfTickets, BigDecimal totalPrice) {
        this.eventID = eventID;
        this.orderedAt = orderedAt;
        this.ticketCategoryID = ticketCategoryID;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public int getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(int ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "eventID=" + eventID +
                ", orderedAt=" + orderedAt +
                ", ticketCategoryID=" + ticketCategoryID +
                ", numberOfTickets=" + numberOfTickets +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
