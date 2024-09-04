import java.util.ArrayList;
import java.util.HashMap;

public class HashMapMulti {

    public static void main(String[] args) {
        // Creating the HashMap
        HashMap<String, ArrayList<String>> multiValueMap = new HashMap<>();

        // Adding values
        addValue(multiValueMap, "key1", "value1");
        addValue(multiValueMap, "key1", "value2");
        addValue(multiValueMap, "key2", "value3");

        // Displaying the HashMap
        System.out.println(multiValueMap);
    }

    // Method to add a value to a specific key
    public static void addValue(HashMap<String, ArrayList<String>> map, String key, String value) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
}
