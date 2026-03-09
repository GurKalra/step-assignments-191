import java.util.*;

public class UsernameAvailabilityChecker {

    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    public static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();
        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username + "_official");
        suggestions.add(username.replace("_", "."));
        return suggestions;
    }

    public static String getMostAttempted() {
        String result = "";
        int max = 0;

        for (String name : attempts.keySet()) {
            int count = attempts.get(name);
            if (count > max) {
                max = count;
                result = name;
            }
        }
        return result + " (" + max + " attempts)";
    }

    public static void main(String[] args) {

        users.put("john_doe", 101);
        users.put("admin", 102);
        users.put("alex", 103);

        System.out.println("checkAvailability(\"john_doe\") → " + checkAvailability("john_doe"));
        System.out.println("checkAvailability(\"jane_smith\") → " + checkAvailability("jane_smith"));

        if (!checkAvailability("john_doe")) {
            System.out.println("suggestAlternatives(\"john_doe\") → " + suggestAlternatives("john_doe"));
        }

        checkAvailability("admin");
        checkAvailability("admin");
        checkAvailability("admin");

        System.out.println("getMostAttempted() → " + getMostAttempted());
    }
}