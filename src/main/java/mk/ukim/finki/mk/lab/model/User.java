package mk.ukim.finki.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.mk.lab.service.impl.PersonNameConverter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "cinema_user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @Convert(converter = PersonNameConverter.class)
    private PersonName personName;
    private String password;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    public User(String username, PersonName personName, String password, LocalDate dateOfBirth) {
        this.username = username;
        this.personName = personName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.carts = new ArrayList<>();
    }
}
