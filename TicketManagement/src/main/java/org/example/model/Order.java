package org.example.model;


import javax.persistence.*;
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
    private Customer customerID;

    @JoinColumn (name = "ticket_category_ID", referencedColumnName = "ticket_category_ID")
    @ManyToOne
    private TicketCategory ticketCategoryID;
    @Column(name="ordered_at")
    private LocalDateTime orderedAt;

    @Column(name="number_of_tickets")
    private Integer numberOfTickets;

    @Column(name="total_price")
    private BigDecimal totalPrice;

    public Order() {
    }

    public Order(Integer orderID, Customer customerID, TicketCategory ticketCategoryID, LocalDateTime orderedAt, Integer numberOfTickets, BigDecimal totalPrice) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.ticketCategoryID = ticketCategoryID;
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

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customer_ID) {
        this.customerID = customer_ID;
    }

    public TicketCategory getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(TicketCategory ticketCategoryID) {
        this.ticketCategoryID = ticketCategoryID;
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
                ", customerID=" + customerID +
                ", ticketCategoryID=" + ticketCategoryID +
                ", ordered_at=" + orderedAt +
                ", number_of_tickets=" + numberOfTickets +
                ", total_price=" + totalPrice +
                '}';
    }
}
