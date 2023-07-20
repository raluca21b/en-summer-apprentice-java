package org.example.dtos;

import org.example.model.Event;
import org.example.model.TicketCategory;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TicketCategoryDTO implements Serializable {

    private Integer ticketCategoryID;
    private String description;
    private BigDecimal price;

    public TicketCategoryDTO() {
    }

    public TicketCategoryDTO(Integer ticketCategoryID, String description, BigDecimal price) {
        this.ticketCategoryID = ticketCategoryID;
        this.description = description;
        this.price = price;
    }

    public Integer getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Integer ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
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
        return "TicketCategoryDTO{" +
                "ticketCategoryID=" + ticketCategoryID +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
