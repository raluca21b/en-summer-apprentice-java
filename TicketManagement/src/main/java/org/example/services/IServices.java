package org.example.services;

import org.example.model.Event;
import org.example.model.Order;
import org.example.model.TicketCategory;

import java.util.List;
import java.util.Optional;

public interface IServices {
     List<Event> getAllEventsByVenueIdAndEventTypeName(int venueId,String eventTypeName);
     List<Event> getAllEvents();
     List<Event> getAllEventsByVenueId(int venueId);
     List<Event> getAllEventsByEventTypeName(String eventTypeName);
     List<TicketCategory> getAllTicketsForAnEvent(Event event);
     List<Order> getOrdersByCustomerID(int customerID);
     Optional<Order> saveOrder(int customerID, int eventID, int ticketCategoryID,int numberOfTickets);

}
