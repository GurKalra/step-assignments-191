import java.util.*;

public class AutocompleteSystem {

    static HashMap<String, Integer> queries = new HashMap<>();

    public static void addQuery(String q) {
        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    public static void search(String prefix) {

        List<String> results = new ArrayList<>();

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix)) {
                results.add(q + " (" + queries.get(q) + ")");
            }
        }

        System.out.println(results);
    }

    public static void main(String[] args) {

        addQuery("java tutorial");
        addQuery("javascript tutorial");
        addQuery("java download");
        addQuery("java tutorial");

        search("jav");
    }
}