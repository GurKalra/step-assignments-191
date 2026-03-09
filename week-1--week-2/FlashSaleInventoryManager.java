import java.util.*;

public class FlashSaleInventoryManager {

    static HashMap<String, Integer> stock = new HashMap<>();
    static LinkedHashMap<Integer, String> waitingList = new LinkedHashMap<>();

    public static void checkStock(String product) {
        int count = stock.getOrDefault(product, 0);
        System.out.println(product + " → " + count + " units available");
    }

    public static void purchaseItem(String product, int userId) {

        int count = stock.getOrDefault(product, 0);

        if (count > 0) {
            stock.put(product, count - 1);
            System.out.println("purchaseItem(\"" + product + "\", userId=" + userId + ") → Success, " + (count - 1) + " units remaining");
        } else {
            waitingList.put(userId, product);
            System.out.println("purchaseItem(\"" + product + "\", userId=" + userId + ") → Added to waiting list, position #" + waitingList.size());
        }
    }

    public static void main(String[] args) {

        stock.put("IPHONE15_256GB", 5);

        checkStock("IPHONE15_256GB");

        purchaseItem("IPHONE15_256GB", 12345);
        purchaseItem("IPHONE15_256GB", 67890);
        purchaseItem("IPHONE15_256GB", 11111);
        purchaseItem("IPHONE15_256GB", 22222);
        purchaseItem("IPHONE15_256GB", 33333);
        purchaseItem("IPHONE15_256GB", 99999);
    }
}