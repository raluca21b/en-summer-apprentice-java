package org.example.controllers;

import org.example.dtos.EventDTO;
import org.example.dtos.TicketCategoryDTO;
import org.example.dtos.VenueDTO;
import org.example.model.Event;
import org.example.model.TicketCategory;
import org.example.services.TicketsManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventsController {
    private TicketsManagementService ticketsManagementService;

    public EventsController(TicketsManagementService ticketsManagementService) {
        this.ticketsManagementService = ticketsManagementService;
    }

    @GetMapping("/events")
    public List<EventDTO> getEvents(@RequestParam(value = "venueID", required = false) Integer venueID, @RequestParam(value = "eventTypeName", required = false) String eventTypeName) {

        List<Event> events;
        if (venueID == null && eventTypeName == null) {
            events = ticketsManagementService.getAllEvents();
        } else if (venueID == null) {
            events = ticketsManagementService.getAllEventsByEventTypeName(eventTypeName);
        } else if (eventTypeName == null) {

            events = ticketsManagementService.getAllEventsByVenueId(venueID);
        } else {
            events = ticketsManagementService.getAllEventsByVenueIdAndEventTypeName(venueID, eventTypeName);
        }
        return getDTOSFromEvents(events);

    }

    private List<TicketCategoryDTO> getDTOSFromTicketCategorys(List<TicketCategory> ticketCategorys) {
        List<TicketCategoryDTO> ticketCategoryDTOS = ticketCategorys.stream()
                .map(ticketCategory -> new TicketCategoryDTO(ticketCategory.getTicketCategoryID(), ticketCategory.getDescription(), ticketCategory.getPrice()))
                .collect(Collectors.toList());

        return ticketCategoryDTOS;
    }

    private List<EventDTO> getDTOSFromEvents(List<Event> events) {
        List<EventDTO> eventsDTOs = events.stream()
                .map(event -> {
                    List<TicketCategoryDTO> ticketCategoryDTOS = getDTOSFromTicketCategorys(ticketsManagementService.getAllTicketsForAnEvent(event));
                    VenueDTO venueDTO = new VenueDTO(event.getVenue().getVenueID(), event.getVenue().getLocation(), event.getVenue().getType(), event.getVenue().getCapacity());
                    return new EventDTO(event.getEventID(), venueDTO, event.getEventType().getEventTypeName(), event.getEventDescription(), event.getEventName(), event.getStartDate(), event.getEndDate(), ticketCategoryDTOS);
                })
                .collect(Collectors.toList());

        return eventsDTOs;
    }
}
