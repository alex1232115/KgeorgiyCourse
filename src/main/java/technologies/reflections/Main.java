package technologies.reflections;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> myClass = BaseParser.class;
        Method[] methods = myClass.getDeclaredMethods();

        for (Method method: methods) {
            System.out.println(method.getName());

        }

    }
}
