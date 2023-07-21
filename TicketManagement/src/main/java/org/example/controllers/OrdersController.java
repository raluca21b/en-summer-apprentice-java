package org.example.controllers;

import org.example.dtos.OrderDTO;
import org.example.model.Order;
import org.example.services.TicketsManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class OrdersController {
    private TicketsManagementService ticketsManagementService;
    private static final Integer customerID = 1;

    public OrdersController(TicketsManagementService ticketsManagementService) {
        this.ticketsManagementService = ticketsManagementService;
    }

    @GetMapping("/orders")
    public List<OrderDTO> getEvents() {
        List<Order> orders = ticketsManagementService.getOrdersByCustomerID(customerID);
        List<OrderDTO> ordersDTOS = getDTOSFromOrders(orders);
        return ordersDTOS;

    }

    @PostMapping("/orders")
    public ResponseEntity<?> create(@RequestBody OrderDTO orderDTO) {
        Optional<Order> orderOptional = ticketsManagementService.saveOrder(customerID, orderDTO.getEventID(), orderDTO.getTicketCategoryID(), orderDTO.getNumberOfTickets());
        if (orderOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Order order = orderOptional.get();
        OrderDTO orderDTOToReturn = new OrderDTO(order.getTicketCategory().getEvent().getEventID(),
                order.getOrderedAt(), order.getTicketCategory().getTicketCategoryID(),
                order.getNumberOfTickets(),
                order.getTotalPrice());
        return new ResponseEntity<OrderDTO>(orderDTOToReturn, HttpStatus.OK);
    }

    private List<OrderDTO> getDTOSFromOrders(List<Order> orders) {
        List<OrderDTO> orderDTOS = orders.stream()
                .map(order -> new OrderDTO(order.getTicketCategory().getEvent().getEventID(),
                        order.getOrderedAt(),
                        order.getTicketCategory().getTicketCategoryID(),
                        order.getNumberOfTickets(),
                        order.getTotalPrice()))
                .collect(Collectors.toList());

        return orderDTOS;
    }
}
