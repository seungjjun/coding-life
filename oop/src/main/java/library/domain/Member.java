package library.domain;

import library.vo.Isbn;
import library.vo.MemberId;

public class Member {

    private final MemberId id;
    private final Books borrowedBooks = new Books();

    public Member(MemberId id) {
        this.id = id;
    }

    public void borrow(String isbn, Books libraryBooks) {
        Book book = libraryBooks.findByIsbn(new Isbn(isbn))
            .orElseThrow(() -> new IllegalArgumentException("Book not found in library: " + isbn));

        this.borrowedBooks.findByIsbn(new Isbn(isbn))
            .ifPresentOrElse(
                existingBook -> {
                    throw new IllegalArgumentException("Book already borrowed: " + existingBook.getIsbn());
                },
                book::lend
            );
    }

    public boolean equalsMember(MemberId memberId) {
        return this.id.equals(memberId);
    }

    public Books displayBorrowedBooks() {
        return borrowedBooks.copy();
    }
}
