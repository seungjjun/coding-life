import java.lang.reflect.Field;
import java.util.Scanner;

public class Reflection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the field to access and modify:");
        String fieldName = scanner.nextLine();

        Person person = new Person("John", 24);

        try {
            Field field = Person.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            Object fieldValue = field.get(person);
            System.out.println("Current value of field " + fieldName + ": " + fieldValue);

            System.out.println("Enter the new value for the field:");
            Object newValue = scanner.nextLine();
            field.set(person, newValue);

            System.out.println("New value of field " + fieldName + ": " + field.get(person));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
