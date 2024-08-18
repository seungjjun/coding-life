package lang.string.test;

import static java.lang.String.join;

public class TestString1 {

	public static void main(String[] args) {
		String url = "https://www.example.com";
		System.out.println(url.startsWith("https://"));

		String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
		int sum = 0;
		for (String s : arr) {
			sum += s.length();
			System.out.println(s + ":" + s.length());
		}
		System.out.println("sum = " + sum);

		String str = "hello.txt";
		int index = str.indexOf(".txt");
		System.out.println("index = " + index);

		String filename = str.substring(0, index);
		String extName = str.substring(index);
		System.out.println("filename = " + filename);
		System.out.println("extName = " + extName);

		String st = "start hello java, hello spring, hello jpa";
		String key = "hello";

		int count = 0;
		int i = st.indexOf(key);
		while (i >= 0) {
			i = st.indexOf(key, i + 1);
			count++;
		}
		System.out.println("count = " + count);

		String original = "      Hello Java ";
		System.out.println(original.strip());

		String input = "hello java spring jpa java";
		System.out.println(input.replace("java", "jvm"));

		String email = "hello@example.com";
		String[] split = email.split("@");
		System.out.println("ID: " + split[0]);
		System.out.println("Domain: " + split[1]);

		String fruits = "apple,banana,mango";
		String[] strings = fruits.split(",");
		for (String s : strings) {
			System.out.println(s);
		}
		System.out.println("joinedString = " + String.join("->", strings));
	}
}
