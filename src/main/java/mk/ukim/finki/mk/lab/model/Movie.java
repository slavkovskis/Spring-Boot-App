package mk.ukim.finki.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Movie {
    private String title;
    private String summary;
    private Double rating;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Production production;

    public Movie(String title, String summary, Double rating, Production production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }

    public Movie(String title, String summary, Double rating, Long id, Production production) {
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.id = id;
        this.production = production;
    }
}
