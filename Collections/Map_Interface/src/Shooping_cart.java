import java.util.*;

public class Shooping_cart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Integer> cart = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> priceMap = new TreeMap<>();
    public void addProduct(String name, double price) {
        productPrices.put(name, price);
        priceMap.putIfAbsent(price, new ArrayList<>());
        priceMap.get(price).add(name);
    }

    public void addToCart(String name, int quantity) {
        if (!productPrices.containsKey(name)) {
            System.out.println("Product not found: " + name);
            return;
        }
        cart.put(name, cart.getOrDefault(name, 0) + quantity);
        System.out.println(name + " x" + quantity + " added to cart.");
    }

    public void showCart() {
        System.out.println("Cart Items (in insertion order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String name = entry.getKey();
            int qty = entry.getValue();
            double price = productPrices.get(name);
            System.out.println(name + " - Quantity: " + qty + " | Price per unit: $" + price);
        }
    }

    public void showItemsSortedByPrice() {
        System.out.println("\nItems sorted by price:");
        for (Map.Entry<Double, List<String>> entry : priceMap.entrySet()) {
            double price = entry.getKey();
            for (String name : entry.getValue()) {
                System.out.println(name + " - $" + price);
            }
        }
    }

    public static void main(String[] args) {
        Shooping_cart cart = new Shooping_cart();

        cart.addProduct("Apple", 1.2);
        cart.addProduct("Milk", 2.5);
        cart.addProduct("Bread", 2.0);
        cart.addProduct("Eggs", 3.0);

        cart.addToCart("Apple", 3);
        cart.addToCart("Milk", 1);
        cart.addToCart("Bread", 2);

        System.out.println();
        cart.showCart();

        System.out.println();
        cart.showItemsSortedByPrice();
    }
}
