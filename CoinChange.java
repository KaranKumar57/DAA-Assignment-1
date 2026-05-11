import java.util.LinkedHashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        int amount = 1988;
        
        // pakistani currency denominations in descending order
        int[] denominations = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};
        
        Map<Integer, Integer> result = new LinkedHashMap<>();

        int remainingAmount = amount;
        for (int coin : denominations) {
            if (remainingAmount >= coin) {
                int count = remainingAmount / coin;
                remainingAmount = remainingAmount % coin; 
                result.put(coin, count);
            }
        }

        System.out.println("total amount: Rs. " + amount);
        System.out.println("\ndenomination | quantity");
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            System.out.printf("Rs. %-8d | %d\n", entry.getKey(), entry.getValue());
        }
    }
}
