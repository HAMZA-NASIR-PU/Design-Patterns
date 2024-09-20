import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {

        try {
            // Map fees = new HashMap<String, Integer>();
            // fees.put("java", 4000);
            // System.out.println(fees);

            Map<String, Integer> fees = (Map) Proxy.newProxyInstance(HashMap.class.getClassLoader(),
                    new Class[] { Map.class }, new ObjectHandlder(new HashMap<String, Integer>()));

            fees.put("Java", 2000);

            fees.put("asp.net core", 2000);

        } catch (Exception e) {

        }

    }
}