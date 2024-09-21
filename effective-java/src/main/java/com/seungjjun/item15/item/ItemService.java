package com.seungjjun.item15.item;

import com.seungjjun.item15.member.MemberService;

public class ItemService {

	MemberService memberService;

	boolean onSale;

	protected int saleRate;

	// 외부에서 배열안의 값을 변경할 수 있기 때문에 public static 배열은 제공하면 안된다.
	public static final String[] NAMES = new String[10];

	public ItemService(MemberService memberService) {
		if (memberService == null) {
			throw new IllegalArgumentException("MemberService should not be null.");
		}
		this.memberService = memberService;
	}

	// memberService 필드를 private로 할 경우 getter를 제공하자.
	MemberService getMemberService() {
		return memberService;
	}
}
