package mk.ukim.finki.mk.lab.service.impl;

import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.TicketOrder;
import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.repository.jpa.ShoppingCartRepository;
import mk.ukim.finki.mk.lab.repository.jpa.TicketOrderRepository;
import mk.ukim.finki.mk.lab.service.TicketOrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketOrderServiceImpl implements TicketOrderService {

    private final TicketOrderRepository ticketOrderRepository;

    public TicketOrderServiceImpl(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, Long numberOfTickets, ShoppingCart shoppingCart, LocalDateTime dateTime) {
        return ticketOrderRepository.save(new TicketOrder(movieTitle, numberOfTickets, shoppingCart, dateTime));
    }

    @Override
    public List<TicketOrder> listAll() {
        return ticketOrderRepository.findAll();
    }



}
