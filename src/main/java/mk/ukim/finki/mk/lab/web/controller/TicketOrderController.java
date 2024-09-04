package mk.ukim.finki.mk.lab.web.controller;

import mk.ukim.finki.mk.lab.model.ShoppingCart;
import mk.ukim.finki.mk.lab.model.User;
import mk.ukim.finki.mk.lab.service.ShoppingCartService;
import mk.ukim.finki.mk.lab.service.TicketOrderService;
import mk.ukim.finki.mk.lab.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    private final TicketOrderService ticketOrderService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;


    public TicketOrderController(TicketOrderService ticketOrderService, UserService userService, ShoppingCartService shoppingCartService) {
        this.ticketOrderService = ticketOrderService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping()
    public String getPage(Model model) {
        User user = userService.findUserByUsername("username").get();
        model.addAttribute("name", user.getPersonName().getName());
        model.addAttribute("tickets", ticketOrderService.listAll());
        return "orderConfirmation";
    }

    @PostMapping("/add")
    public String ticketOrder(@RequestParam String movieName,
                              @RequestParam Long numTickets,
                              @RequestParam(value = "dateCreated")
                                  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
        User user = userService.findUserByUsername("username").get();
        ShoppingCart shoppingCart = shoppingCartService.findShoppingCartByUser(user).get();
        ticketOrderService.placeOrder(movieName, numTickets, shoppingCart, dateTime);
        return "redirect:/ticketOrder";
    }

}
