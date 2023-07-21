package org.example.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_ID")
    private Integer orderID;

    @JoinColumn (name = "customer_ID", referencedColumnName = "customer_ID")
    @ManyToOne
    private Customer customer;

    @JoinColumn (name = "ticket_category_ID", referencedColumnName = "ticket_category_ID")
    @ManyToOne
    private TicketCategory ticketCategory;
    @Column(name="ordered_at")
    private LocalDateTime orderedAt;

    @Column(name="number_of_tickets")
    private Integer numberOfTickets;

    @Column(name="total_price")
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(Customer customer, TicketCategory ticketCategory, LocalDateTime orderedAt, Integer numberOfTickets, BigDecimal totalPrice) {
        this.customer = customer;
        this.ticketCategory = ticketCategory;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public Order(Integer orderID, Customer customer, TicketCategory ticketCategory, LocalDateTime orderedAt, Integer numberOfTickets, BigDecimal totalPrice) {
        this.orderID = orderID;
        this.customer = customer;
        this.ticketCategory = ticketCategory;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer order_ID) {
        this.orderID = order_ID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer_ID) {
        this.customer = customer_ID;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategory ticketCategoryID) {
        this.ticketCategory = ticketCategoryID;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(LocalDateTime ordered_at) {
        this.orderedAt = ordered_at;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer number_of_tickets) {
        this.numberOfTickets = number_of_tickets;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal total_price) {
        this.totalPrice = total_price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customer=" + customer +
                ", ticketCategory=" + ticketCategory +
                ", ordered_at=" + orderedAt +
                ", number_of_tickets=" + numberOfTickets +
                ", total_price=" + totalPrice +
                '}';
    }
}
