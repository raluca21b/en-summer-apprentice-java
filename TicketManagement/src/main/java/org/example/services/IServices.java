package org.example.services;

import org.example.model.Event;
import org.example.model.Order;
import org.example.model.TicketCategory;

import java.util.List;

public interface IServices {
     List<Event> getAllEventsByVenueIdAndEventTypeName(Integer venueId,String eventTypeName);
     List<TicketCategory> getAllTicketsForAnEventID(Event event);
     List<Order> getOrdersByCustomerID(Integer customerID);
}
