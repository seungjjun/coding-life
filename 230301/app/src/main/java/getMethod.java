import java.lang.reflect.Method;

public class getMethod {
    public static void main(String[] args) {
        Method[] methods = Person.class.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }
    }
}
