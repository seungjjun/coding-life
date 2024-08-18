package lang.immutable.address;

public class RefMain {

	public static void main(String[] args) {
		ImmutableAddress a = new ImmutableAddress("서울"); // 불변 객체  a -> x001
		ImmutableAddress b = a; // 참조값 대입  b -> x001

		System.out.println("a = " + a);
		System.out.println("b = " + b);

		b = new ImmutableAddress("부산"); // 새로운 불변 객체 생성  b -> x002
		System.out.println("a = " + a); // x001
		System.out.println("b = " + b); // x002
	}
}
