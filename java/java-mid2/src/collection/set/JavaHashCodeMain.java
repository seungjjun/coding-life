package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {

	public static void main(String[] args) {
		Object object1 = new Object();
		Object object2 = new Object();
		System.out.println("object1.hashCode() = " + object1.hashCode());
		System.out.println("object2.hashCode() = " + object2.hashCode());

		Member member1 = new Member("idA");
		Member member2 = new Member("idA");

		System.out.println("member1.equals(member2) = " + member1.equals(member2));
		System.out.println("member1.hashCode() = " + member1.hashCode());
		System.out.println("member2.hashCode() = " + member2.hashCode());
	}
}
