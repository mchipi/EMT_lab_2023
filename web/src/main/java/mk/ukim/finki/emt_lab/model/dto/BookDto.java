package mk.ukim.finki.emt_lab.model.dto;

import lombok.Data;
import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.enums.Category;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDto() {
    }
}
