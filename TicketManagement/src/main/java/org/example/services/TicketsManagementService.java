package org.example.services;

import org.example.model.Event;
import org.example.model.TicketCategory;
import org.example.repository.*;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class TicketsManagementService implements IServices{
    private CustomerRepository customerRepository;
    private EventRepository eventRepository;
    private EventTypeRepository eventTypeRepository;
    private VenueRepository venueRepository;
    private TicketCategoryRepository ticketCategoryRepository;
    private OrderRepository orderRepository;

    public TicketsManagementService(CustomerRepository customerRepository, EventRepository eventRepository, EventTypeRepository eventTypeRepository, VenueRepository venueRepository, TicketCategoryRepository ticketCategoryRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.eventRepository = eventRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.venueRepository = venueRepository;
        this.ticketCategoryRepository = ticketCategoryRepository;
        this.orderRepository = orderRepository;
        System.out.println("initializing EventsService..............");
    }

    @Override
    public List<Event> getAllEventsByVenueIdAndEventTypeName(Integer venueId,String eventTypeName){
        return eventRepository.getAllByVenueVenueIDAndEventTypeEventTypeName(venueId,eventTypeName);
    }
    @Override
    public List<TicketCategory> getAllTicketsForAnEventID(Event event){
        return ticketCategoryRepository.findTicketCategoriesByEvent(event);
    }
}
