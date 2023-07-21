package org.example.services;

import org.example.model.Event;
import org.example.model.Order;
import org.example.model.TicketCategory;

import java.util.List;
import java.util.Optional;

public interface IServices {
     List<Event> getAllEventsByVenueIdAndEventTypeName(Integer venueId,String eventTypeName);
     List<Event> getAllEvents();
     List<Event> getAllEventsByVenueId(Integer venueId);
     List<Event> getAllEventsByEventTypeName(String eventTypeName);
     List<TicketCategory> getAllTicketsForAnEvent(Event event);
     List<Order> getOrdersByCustomerID(Integer customerID);
     Optional<Order> saveOrder(Integer customerID, Integer eventID, Integer ticketCategoryID,Integer numberOfTickets);

}
