package lang.immutable.address;

public class MemberMainV2 {

	public static void main(String[] args) {
		ImmutableAddress address = new ImmutableAddress("서울");

		MemberV2 a = new MemberV2("A", address);
		MemberV2 b = new MemberV2("B", address);

		System.out.println("a = " + a);
		System.out.println("b = " + b);

		b.setAddress(new ImmutableAddress("부산"));

		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
