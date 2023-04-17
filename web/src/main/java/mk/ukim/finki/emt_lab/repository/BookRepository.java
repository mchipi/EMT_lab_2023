package mk.ukim.finki.emt_lab.repository;

import mk.ukim.finki.emt_lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional
    void deleteByName(String name);
    Book findByName(String name);
    boolean existsByName(String name);
}
