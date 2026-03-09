import java.util.*;

public class MultiLevelCacheSystem {

    static LinkedHashMap<String, String> L1 = new LinkedHashMap<>(10000, 0.75f, true);
    static HashMap<String, String> L2 = new HashMap<>();
    static HashMap<String, String> L3 = new HashMap<>();

    public static String getVideo(String id) {

        if (L1.containsKey(id)) {
            return "L1 Cache HIT";
        }

        if (L2.containsKey(id)) {
            L1.put(id, L2.get(id));
            return "L2 Cache HIT → promoted to L1";
        }

        if (L3.containsKey(id)) {
            L2.put(id, L3.get(id));
            return "L3 Database HIT → added to L2";
        }

        return "Video not found";
    }

    public static void main(String[] args) {

        L3.put("video_123", "data");

        System.out.println(getVideo("video_123"));
        System.out.println(getVideo("video_123"));
    }
}