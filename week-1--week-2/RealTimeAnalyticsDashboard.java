import java.util.*;

public class RealTimeAnalyticsDashboard {

    static HashMap<String, Integer> pageViews = new HashMap<>();
    static HashMap<String, Set<String>> uniqueVisitors = new HashMap<>();
    static HashMap<String, Integer> trafficSource = new HashMap<>();

    public static void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSource.put(source, trafficSource.getOrDefault(source, 0) + 1);
    }

    public static void showDashboard() {

        System.out.println("Top Pages:");

        for (String page : pageViews.keySet()) {
            System.out.println(page + " - " + pageViews.get(page) + " views (" + uniqueVisitors.get(page).size() + " unique)");
        }

        System.out.println("\nTraffic Sources:");
        System.out.println(trafficSource);
    }

    public static void main(String[] args) {

        processEvent("/article/breaking-news", "user123", "google");
        processEvent("/article/breaking-news", "user456", "facebook");
        processEvent("/sports/championship", "user789", "direct");

        showDashboard();
    }
}