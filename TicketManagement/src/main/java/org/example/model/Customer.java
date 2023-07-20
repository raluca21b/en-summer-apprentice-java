package org.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_ID")
    private Integer customerID;

    @Column(name="customer_name")
    private String customerName;


    @Column(name="email",unique = true)
    private String email;

    public Customer() {
    }

    public Customer(Integer customer_ID, String customerName, String email) {
        this.customerID = customer_ID;
        this.customerName = customerName;
        this.email = email;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customer_ID) {
        this.customerID = customer_ID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customer_name) {
        this.customerName = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_ID=" + customerID +
                ", customer_name='" + customerName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
