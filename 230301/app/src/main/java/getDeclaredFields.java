import java.lang.reflect.Field;

public class getDeclaredFields {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Jun", 25);
        printPersonDetails(person);
    }

    public static void printPersonDetails(Person person) throws IllegalAccessException {
        Field[] fields = Person.class.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            System.out.println(field.getName() + ": " + field.get(person));
        }
    }
}
