package org.example.services;

import org.example.model.Customer;
import org.example.model.Event;
import org.example.model.Order;
import org.example.model.TicketCategory;

import org.example.repository.CustomerRepository;
import org.example.repository.EventRepository;
import org.example.repository.EventTypeRepository;
import org.example.repository.VenueRepository;
import org.example.repository.TicketCategoryRepository;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TicketsManagementService implements IServices{
    private final CustomerRepository customerRepository;
    private final EventRepository eventRepository;
    private final EventTypeRepository eventTypeRepository;
    private final VenueRepository venueRepository;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final OrderRepository orderRepository;

    public TicketsManagementService(CustomerRepository customerRepository, EventRepository eventRepository, EventTypeRepository eventTypeRepository, VenueRepository venueRepository, TicketCategoryRepository ticketCategoryRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.eventRepository = eventRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.venueRepository = venueRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Event> getAllEventsByVenueIdAndEventTypeName(Integer venueId,String eventTypeName){
        return eventRepository.getAllByVenueVenueIDAndEventTypeEventTypeName(venueId,eventTypeName);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByVenueId(Integer venueId) {
        return eventRepository.getAllByVenueVenueID(venueId);
    }

    @Override
    public List<Event> getAllEventsByEventTypeName(String eventTypeName) {
        return eventRepository.getAllByEventTypeEventTypeName(eventTypeName);
    }

    @Override
    public List<TicketCategory> getAllTicketsForAnEvent(Event event){
        return ticketCategoryRepository.findTicketCategoriesByEvent(event);
    }

    @Override
    public List<Order> getOrdersByCustomerID(Integer customerID) {
        return orderRepository.getOrdersByCustomerCustomerID(customerID);
    }

    @Override
    public Optional<Order> saveOrder(Integer customerID, Integer eventID, Integer ticketCategoryID,Integer numberOfTickets) {
        TicketCategory ticketCategory = ticketCategoryRepository.findTicketCategoryByTicketCategoryID(ticketCategoryID);
        Order order;
        if (ticketCategory == null ){
            return Optional.empty();
        }else if(!Objects.equals(ticketCategory.getEvent().getEventID(), eventID)){
            return Optional.empty();
        }
        else{
            BigDecimal totalPrice = BigDecimal.valueOf(numberOfTickets).multiply(ticketCategory.getPrice());
            Customer customer = customerRepository.getById(customerID);
            order = new Order(customer,ticketCategory, LocalDateTime.now(),numberOfTickets,totalPrice);
            orderRepository.save(order);
        }
        return Optional.of(order);
    }
}
