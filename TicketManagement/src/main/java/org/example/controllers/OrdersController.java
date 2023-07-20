package org.example.controllers;

import org.example.dtos.OrderDTO;
import org.example.model.Order;
import org.example.services.TicketsManagementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrdersController {
    private TicketsManagementService ticketsManagementService;

    public OrdersController(TicketsManagementService ticketsManagementService) {
        this.ticketsManagementService = ticketsManagementService;
    }
    @GetMapping("/orders")
    public ResponseEntity<?> getEvents(){
        List<Order> orders= ticketsManagementService.getOrdersByCustomerID(1);
        List<OrderDTO> ordersDTOS= getDTOSFromOrders(orders);
        if (ordersDTOS.size() == 0)
            return new ResponseEntity<String>("Orders not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<List<OrderDTO>>(ordersDTOS, HttpStatus.OK);

    }

    private List<OrderDTO> getDTOSFromOrders(List<Order> orders) {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order order:orders
             ) {
                OrderDTO orderDTO = new OrderDTO(order.getTicketCategoryID().getEvent().getEventID(),
                        order.getOrderedAt(),order.getTicketCategoryID().getTicketCategoryID(),
                        order.getNumberOfTickets(),
                        order.getTotalPrice());
                orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }
}
