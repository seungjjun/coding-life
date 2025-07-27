package library.domain;

import library.vo.MemberId;

public class Member {

    private final MemberId id;
    private final Books borrowedBooks = new Books();

    public Member(MemberId id) {
        this.id = id;
    }

    public void borrow(Book book) {
        if (this.borrowedBooks.findByIsbn(book.getIsbn()).isPresent()) {
            throw new IllegalArgumentException("Book already borrowed: " + book.getIsbn());
        }
        borrowedBooks.addBook(book);
    }

    public void returnBook(Book book) {
        if (this.borrowedBooks.findByIsbn(book.getIsbn()).isEmpty()) {
            throw new IllegalArgumentException("Book not borrowed: " + book.getIsbn());
        }
        borrowedBooks.remove(book);
    }

    public boolean matchesId(MemberId memberId) {
        return this.id.equals(memberId);
    }

    public Books displayBorrowedBooks() {
        return borrowedBooks.copy();
    }

    public int checkBorrowedBookSize() {
        return this.borrowedBooks.size();
    }
}
