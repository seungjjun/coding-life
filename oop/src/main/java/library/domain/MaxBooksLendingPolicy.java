package library.domain;

public class MaxBooksLendingPolicy implements LendingPolicy {

    private static final int MAX_BORROWED_BOOKS = 5;

    @Override
    public void apply(Member member, Book book) {
        if (member.checkBorrowedBookSize() >= MAX_BORROWED_BOOKS) {
            throw new IllegalArgumentException("Cannot borrow more than " + MAX_BORROWED_BOOKS + " books.");
        }
    }
}
