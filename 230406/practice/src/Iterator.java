import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Iterator {
    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");

        java.util.Iterator<String> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        Set<String> set = new LinkedHashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        if (set.size() > 2) {
            java.util.Iterator<String> it = set.iterator();
            System.out.println(it.next());
            it.remove();
        }
    }
}
