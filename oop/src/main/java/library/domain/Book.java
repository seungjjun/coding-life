package library.domain;

import library.vo.Isbn;

public class Book {

    private final Isbn isbn;
    private final String title;
    private BorrowStatus borrowStatus;

    public Book(Isbn isbn, String title) {
        this.isbn = isbn;
        this.title = title;
        this.borrowStatus = BorrowStatus.AVAILABLE;
    }

    public boolean equalsBook(Book book) {
        return matchIsbn(book.isbn);
    }

    public boolean matchIsbn(Isbn isbn) {
        return this.isbn.equals(isbn);
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public void lend() {
        if (!this.borrowStatus.equals(BorrowStatus.AVAILABLE)) {
            throw new IllegalArgumentException("Book is not available for lending: " + isbn);
        }
        this.borrowStatus = BorrowStatus.CHECKED_OUT;
    }
}