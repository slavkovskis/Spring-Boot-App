package mk.ukim.finki.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
public class TicketOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String movieTitle;

    private Long numberOfTickets;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateCreated;

    @ManyToOne
    private ShoppingCart shoppingCart;


    public TicketOrder(String movieTitle, Long numberOfTickets, ShoppingCart shoppingCart, LocalDateTime dateTime) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;
        this.shoppingCart = shoppingCart;
        this.dateCreated = (LocalDateTime) Objects.requireNonNullElseGet(
                dateTime,
                () -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
        );
    }
}
