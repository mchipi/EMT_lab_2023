package mk.ukim.finki.emt_lab.model;

import lombok.Data;
import mk.ukim.finki.emt_lab.model.enums.Category;

import javax.persistence.*;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;
    private Integer availableCopies;

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }

}
