package lang.string.immutable;

public class StringImmutable1 {

	public static void main(String[] args) {
		String str = "hello";
		str.concat(" java");
		System.out.println("str = " + str);

		String str2 = str.concat(" java"); // 불변객체 -> 새로운 객체 반환 필요
		System.out.println("str2 = " + str2);
	}
}
