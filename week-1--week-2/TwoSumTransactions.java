import java.util.*;

public class TwoSumTransactions {

    public static void findTwoSum(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + complement + " + " + num);
                return;
            }

            map.put(num, 1);
        }

        System.out.println("No pair found");
    }

    public static void main(String[] args) {

        int[] transactions = {500, 300, 200};

        findTwoSum(transactions, 500);
    }
}