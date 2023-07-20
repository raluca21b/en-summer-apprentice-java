package org.example.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="TicketCategory")
public class TicketCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_category_ID")
    private Integer ticketCategoryID;

    @JoinColumn (name = "event_ID", referencedColumnName = "event_ID")
    @ManyToOne
    private Event event;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    public TicketCategory() {
    }

    public TicketCategory(Integer ticketCategoryID, Event event, String description, BigDecimal price) {
        this.ticketCategoryID = ticketCategoryID;
        this.event = event;
        this.description = description;
        this.price = price;
    }

    public Integer getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Integer ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TicketCategory{" +
                "ticketCategoryID=" + ticketCategoryID +
                ", event=" + event +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
