package lang.string.chaining;

public class MethodChainingMain {

	public static void main(String[] args) {
		ValueAdder adder = new ValueAdder();
		adder.add(1);
		adder.add(2);
		adder.add(3);

		int result = adder.getValue();
		System.out.println("result = " + result);

		ValueAdder adder1 = new ValueAdder();
		ValueAdder adder2 = adder1.add(1);
		ValueAdder adder3 = adder2.add(2);
		ValueAdder adder4 = adder3.add(3);

		int result2 = adder4.getValue();
		System.out.println("result2 = " + result2);


		ValueAdder adder5 = new ValueAdder();
		ValueAdder adder6 = adder5.add(1).add(2).add(3);
		int result3 = adder6.getValue();
		System.out.println("result3 = " + result3);
	}
}
