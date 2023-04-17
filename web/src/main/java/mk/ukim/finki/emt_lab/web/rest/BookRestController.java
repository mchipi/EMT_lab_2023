package mk.ukim.finki.emt_lab.web.rest;

import mk.ukim.finki.emt_lab.model.Author;
import mk.ukim.finki.emt_lab.model.Book;
import mk.ukim.finki.emt_lab.model.Country;
import mk.ukim.finki.emt_lab.model.dto.BookDto;
import mk.ukim.finki.emt_lab.model.enums.Category;
import mk.ukim.finki.emt_lab.service.AuthorService;
import mk.ukim.finki.emt_lab.service.BookService;
import mk.ukim.finki.emt_lab.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public BookRestController(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;

        Country country1 = new Country("mkd", "evropa");
        Author author1 = new Author("marija", "chipishkova", country1);
        Author author2 = new Author("sara", "chipishkova", country1);
        this.countryService.save(country1);
        this.authorService.save(author1);
        this.authorService.save(author2);
        this.bookService.save("kniga1", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga2", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga3", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga4", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga5", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga6", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga7", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga8", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga9", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga10", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga11", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga12", Category.BIOGRAPHY, author1, 2);
        this.bookService.save("kniga13", Category.BIOGRAPHY, author1, 2);
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return Optional.of(bookService.save(bookDto))
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

//    @PostMapping("/add")
//    public ResponseEntity<Book> save(@RequestParam String name, @RequestParam Category category, @RequestParam Author author, @RequestParam Integer copies) {
//        return Optional.of(bookService.save(name, category, author, copies))
//                .map(book -> ResponseEntity.ok().body(book))
//                .orElseGet(() -> ResponseEntity.badRequest().build());
//    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return Optional.of(bookService.save(bookDto))
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if (this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}/rent")
    public ResponseEntity<Book> rentBookById(@PathVariable Long id) {
        Book book = bookService.rentBookById(id);
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/categories")
    public List<Category> findAllCategories() {
        return Arrays.stream(Category.values()).toList();
    }

    // create read update delete
}
