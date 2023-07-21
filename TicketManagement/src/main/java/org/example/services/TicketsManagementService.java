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
public class TicketsManagementService implements IServices {
    private final CustomerRepository customerRepository;
    private final EventRepository eventRepository;
    private final EventTypeRepository eventTypeRepository;
    private final VenueRepository venueRepository;
    private final TicketCategoryRepository ticketCategoryRepository;
    private final OrderRepository orderRepository;

    public TicketsManagementService(CustomerRepository customerRepository, EventRepository eventRepository,
                                    EventTypeRepository eventTypeRepository, VenueRepository venueRepository,
                                    TicketCategoryRepository ticketCategoryRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.eventRepository = eventRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.venueRepository = venueRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Event> getAllEventsByVenueIdAndEventTypeName(int venueId, String eventTypeName) {
        return eventRepository.getAllByVenueVenueIDAndEventTypeEventTypeName(venueId, eventTypeName);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getAllEventsByVenueId(int venueId) {
        return eventRepository.getAllByVenueVenueID(venueId);
    }

    @Override
    public List<Event> getAllEventsByEventTypeName(String eventTypeName) {
        return eventRepository.getAllByEventTypeEventTypeName(eventTypeName);
    }

    @Override
    public List<TicketCategory> getAllTicketsForAnEvent(Event event) {
        return ticketCategoryRepository.findTicketCategoriesByEvent(event);
    }

    @Override
    public List<Order> getOrdersByCustomerID(int customerID) {
        return orderRepository.getOrdersByCustomerCustomerID(customerID);
    }

    @Override
    public Optional<Order> saveOrder(int customerID, int eventID, int ticketCategoryID, int numberOfTickets) {
        Optional<TicketCategory> ticketCategory = ticketCategoryRepository.findTicketCategoryByTicketCategoryID(ticketCategoryID);
        if (ticketCategory.isEmpty()) {
            return Optional.empty();
        } else if (!ticketCategory.get().getEvent().getEventID().equals(eventID)) {
            return Optional.empty();
        } else {
            BigDecimal totalPrice = BigDecimal.valueOf(numberOfTickets).multiply(ticketCategory.get().getPrice());
            Customer customer = customerRepository.getById(customerID);
            Order order = new Order(customer, ticketCategory.get(), LocalDateTime.now(), numberOfTickets, totalPrice);
            order = orderRepository.save(order);
            return Optional.of(order);
        }
    }
}
