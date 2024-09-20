import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ObjectHandlder implements InvocationHandler {

    private Object object;

    public ObjectHandlder(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // logic before method call
        System.out.println("Before method call");

        if (method.getName().contains("put")) {
            if (args[0].equals("Java")) {
                System.out.println("Invalid key: Java");
            }
        }

        method.invoke(object, args);
        // logic after method call
        System.out.println("After method call");

        return null;
    }
}
