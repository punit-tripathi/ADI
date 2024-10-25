package ADIlec12;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    double weight, value, ratio;

    Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
        this.ratio = value / weight;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(int capacity, Item[] items) {
        // Sort items by descending value-to-weight ratio
        Arrays.sort(items, Comparator.comparingDouble(item -> -item.ratio));

        double totalValue = 0;

        for (Item item : items) {
            if (capacity == 0) break;  // Knapsack is full

            // Take the full item if possible
            if (item.weight <= capacity) {
                totalValue += item.value;
                capacity -= item.weight;
            } else {
                // Take the fraction of the remaining capacity
                totalValue += item.ratio * capacity;
                capacity = 0;  // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };
        int capacity = 50;  // Knapsack capacity

        double maxValue = getMaxValue(capacity, items);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}
