package mk.ukim.finki.mk.lab.service;

import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.TicketOrder;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketOrderService {
    TicketOrder placeOrder(String movieTitle, Long numberOfTickets, ShoppingCart shoppingCart, LocalDateTime dateTime);

    List<TicketOrder> listAll();
}
