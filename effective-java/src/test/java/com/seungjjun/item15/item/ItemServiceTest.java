package com.seungjjun.item15.item;

import com.seungjjun.item15.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class ItemServiceTest {

	@Mock
	MemberService memberService;

	@Test
	void itemService() {
		ItemService service = new ItemService(memberService);
		assertNotNull(service);
		assertNotNull(service.memberService); // memberService 멤버가 package-private 이기 때문에 접근이 가능하다.
	}

}
