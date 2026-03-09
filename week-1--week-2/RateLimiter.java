import java.util.*;

class TokenBucket {

    int tokens;
    long lastRefill;

    TokenBucket(int max) {
        tokens = max;
        lastRefill = System.currentTimeMillis();
    }
}

public class RateLimiter {

    static HashMap<String, TokenBucket> clients = new HashMap<>();
    static int LIMIT = 5;

    public static void checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(LIMIT));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            System.out.println("Allowed (" + bucket.tokens + " requests remaining)");
        } else {
            System.out.println("Denied (limit exceeded)");
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 7; i++) {
            checkRateLimit("abc123");
        }
    }
}