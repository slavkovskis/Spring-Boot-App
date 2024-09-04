//package mk.ukim.finki.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.mk.lab.model.TicketOrder;
//import mk.ukim.finki.mk.lab.service.impl.TicketOrderServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name="ticket", urlPatterns = "/ticketOrder")
//public class TicketOrderServlet extends HttpServlet {
//    private final SpringTemplateEngine springTemplateEngine;
//    private final TicketOrderServiceImpl ticketOrderService;
//
//    public TicketOrderServlet(SpringTemplateEngine springTemplateEngine, TicketOrderServiceImpl ticketOrderService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.ticketOrderService = ticketOrderService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("tickets", ticketOrderService.listAll());
//        this.springTemplateEngine.process("orderConfirmation.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String movieName = req.getParameter("movieName");
//        long numTickets = Long.parseLong(req.getParameter("numTickets"));
//
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//
//        context.setVariable("ipAddress", req.getRemoteAddr());
//        context.setVariable("clientName", "Slave Slavkovski");
//        context.setVariable("movie", movieName);
//        context.setVariable("numTickets", numTickets);
//        context.setVariable("tickets", ticketOrderService.listAll());
//        ticketOrderService.placeOrder(movieName, "Slave Slavkovski", req.getRemoteAddr(), numTickets);
//        this.springTemplateEngine.process("orderConfirmation.html", context, resp.getWriter());
//    }
//}