package javaapplication2;

import java.util.HashMap; 
import java.util.Map;

public class PhoneBook {
    private HashMap<String, String> customerMap = new HashMap();

    public boolean add (String key, String value) {
	if (customerMap.containsKey(key)) throw new IllegalArgumentException(
                "This phone number already exists in the list");
        customerMap.put(key, value);
        return true;
    }

    public String searchByName (String value) {
        for (Map.Entry<String, String> e : customerMap.entrySet()) {
            if (e.getValue().equals(value))
                return e.getKey();
        }
        return "unlisted";
    }

    public String searchByNumber (String key) {
            if (customerMap.containsKey(key))
                return customerMap.get(key);
        return "unlisted";
    }

}
