package library.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import library.vo.MemberId;

public class Members {

    private final List<Member> members = new ArrayList<>();

    public Optional<Member> findMemberById(MemberId memberId) {
        return this.members.stream()
            .filter(member -> member.equalsMember(memberId))
            .findFirst();
    }

    public void addMember(MemberId newMemberId) {
        members.stream()
            .filter(member -> member.equalsMember(newMemberId))
            .findFirst()
            .ifPresentOrElse(
                existingMember -> {
                    throw new IllegalArgumentException("Member already exists with ID: " + newMemberId);
                },
                () -> members.add(new Member(newMemberId))
            );
    }

    public void lendBookTo(String memberId, String isbn, Books libraryBooks) {
        Member foundMember = findMemberById(new MemberId(memberId))
            .orElseThrow(() -> new IllegalArgumentException("Member not found with ID: " + memberId));
        foundMember.borrow(isbn, libraryBooks);
    }
}
