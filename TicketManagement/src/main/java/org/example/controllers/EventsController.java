package org.example.controllers;

import org.example.dtos.EventDTO;
import org.example.dtos.TicketCategoryDTO;
import org.example.model.Event;
import org.example.model.TicketCategory;
import org.example.services.TicketsManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventsController {
    private TicketsManagementService ticketsManagementService;

    public EventsController(TicketsManagementService ticketsManagementService) {
        this.ticketsManagementService = ticketsManagementService;
        System.out.println("Creating Events Controller.......");
    }

    public List<TicketCategoryDTO> getDTOsFromTicketCategorys(List<TicketCategory> ticketCategorys){
        List<TicketCategoryDTO> ticketCategoryDTOS = new ArrayList<>();
        for (TicketCategory ticketCategory:ticketCategorys
        ) {
            TicketCategoryDTO ticketCategoryDTO = new TicketCategoryDTO(ticketCategory.getTicketCategoryID(),ticketCategory.getDescription(),ticketCategory.getPrice());
            ticketCategoryDTOS.add(ticketCategoryDTO);
        }
        return ticketCategoryDTOS;
    }

    public List<EventDTO> getDTOSFromEvents(List<Event> events){
        List<EventDTO> eventsDTOs= new ArrayList<>();
        for (Event event:events
        ) {
            List<TicketCategoryDTO>  ticketCategoryDTOS= getDTOsFromTicketCategorys(ticketsManagementService.getAllTicketsForAnEventID(event));
            EventDTO eventDTO =  new EventDTO(event.getEventID(),event.getVenue(),event.getEventType().getEventTypeName(),
                    event.getEventDescription(),event.getEventName(),event.getStartDate(),event.getEndDate());
            eventDTO.setTicketsCategory(ticketCategoryDTOS);
            eventsDTOs.add(eventDTO);
        }
        return eventsDTOs;
    }

    @GetMapping("/events")
    public ResponseEntity<?> getEvents(@RequestParam(value="venueID") Integer venueID, @RequestParam(value = "eventTypeName") String eventTypeName){
        List<Event> events= ticketsManagementService.getAllEventsByVenueIdAndEventTypeName(venueID,eventTypeName);
        List<EventDTO> eventsDTOs= getDTOSFromEvents(events);
        if (eventsDTOs.size() == 0)
            return new ResponseEntity<String>("Events not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<EventDTO>>(eventsDTOs, HttpStatus.OK);

    }
}
