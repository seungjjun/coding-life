import java.util.ArrayList;

public class Generic {
    public static void main(String[] args) {
        Box<String> boxOfStrings = new Box<>();
        boxOfStrings.put("parcel");
        String content = boxOfStrings.get();
        System.out.println("content = " + content);

        Box<Integer> boxOfIntegers = new Box<>();
        boxOfIntegers.put(10);
        Integer number = boxOfIntegers.get();
        System.out.println("number = " + number);

        /*
        ArrayList list = new ArrayList();

        list.add(10);
        list.add(20);
        list.add("10");

        Integer number = (Integer) list.get(2);

        System.out.println("number = " + number);
         */
    }
}
