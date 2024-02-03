package Maps;

import java.util.HashMap;

public class Maps {
    public static void main(String[] args) {
        HashMap<String,Integer> empIds = new HashMap<>();
        empIds.put("John",1234);
        empIds.put("Carl",12321);
        empIds.put("Halil",12321);
        System.out.println(empIds);

        System.out.println(empIds.get("Halil"));
        System.out.println(empIds.containsKey("John"));
        System.out.println(empIds.containsValue(180));

        empIds.put("Halil",180);//this will override the current value
        empIds.replace("lol",123);// nothing will happen cause this key doesn't exist

        System.out.println(empIds.containsValue(180));
        empIds.putIfAbsent("John",45);//this will work if the key doesn't exist
        System.out.println(empIds);

    }
}
