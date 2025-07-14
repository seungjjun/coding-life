package library.domain;

import library.vo.Isbn;
import library.vo.MemberId;

public class Library {

    private final Books books = new Books();
    private final Members members = new Members();

    public void addBook(Book book) {
        this.books.addBook(book);
    }

    public void addMember(String memberId) {
        members.addMember(new MemberId(memberId));
    }

    public void lendBook(String memberId, String isbn) {
        members.lendBookTo(memberId, isbn, books);
    }

    public Book findBookByIsbn(String isbn) {
        return this.books.findByIsbn(new Isbn(isbn))
            .orElseThrow(() -> new IllegalArgumentException("Book not found with ISBN: " + isbn));
    }

    public Books checkLendingBooksByMemberId(String memberId) {
        Member foundMember = members.findMemberById(new MemberId(memberId))
            .orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + memberId));
        return foundMember.displayBorrowedBooks();
    }
}
