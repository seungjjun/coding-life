package library.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import library.vo.Isbn;

public class Books {

    private final List<Book> values;

    public Books() {
        this.values = new ArrayList<>();
    }

    public Books(List<Book> books) {
        this.values = new ArrayList<>(books);
    }

    public void addBook(Book book) {
        boolean isRegisteredBook = this.values.stream()
            .anyMatch(registeredBook -> registeredBook.equalsBook(book));

        if (isRegisteredBook) {
            throw new IllegalArgumentException("Book already exists with ISBN: " + book.getIsbn());
        }
        this.values.add(book);
    }

    public Optional<Book> findByIsbn(Isbn isbn) {
        return values.stream()
            .filter(book -> book.matchIsbn(isbn))
            .findFirst();
    }

    public void removeBook(Book book) {
        this.values.remove(book);
    }

    public Books copy() {
        return new Books(values);
    }
}
