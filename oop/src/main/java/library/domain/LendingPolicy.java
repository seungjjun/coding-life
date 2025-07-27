package library.domain;

public interface LendingPolicy {

    void apply(Member member, Book book);

}
