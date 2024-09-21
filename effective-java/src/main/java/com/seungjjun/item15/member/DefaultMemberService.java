package com.seungjjun.item15.member;

// package-private 레벨 -> 구현체는 내부 패키지 안에서만 알면 되고, 패키지 밖에서는 MemberService의 구현체를 알 필요가 없다.
class DefaultMemberService implements MemberService {

	/**
	 * MemberRepository 를 DefaultMemberService 클래스에서만 사용하는 경우
	 * 별도의 클래스(인터페이스)를 생성하는것이 아닌 private static 으로 중첩시키자.
	 *
	 * inner private class가 아닌 private static class 으로 선언하는 이유 ->
	 * inner private class는 inner private class를 감싸고 있는 외부 인스턴스를 참조한다.
	 * MemberRepository 클래스에서 DefaultMemberService 클래스에 선언된 멤버에 접근이 수월하다.
	 * private static class는 inner class 이지만 이를 감싸고 있는 클래스와 남남 관계이다. -> 단방향 관계
	 */
	 private static class MemberRepository { }

//	 private class MemberRepository { }
}
