package behavioural;

import java.util.ArrayList;
import java.util.List;

// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

// Concrete Strategy
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}

// Context
class ShoppingCart {
    private List<Integer> items = new ArrayList<>();

    public void addItem(int price) {
        items.add(price);
    }

    public void pay(PaymentStrategy paymentStrategy) {
        int total = items.stream().mapToInt(Integer::intValue).sum();
        paymentStrategy.pay(total);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(100);
        cart.addItem(200);

        cart.pay(new CreditCardPayment("1234-5678-9876-5432"));  // Output: Paid 300 using Credit Card: 1234-5678-9876-5432
        cart.pay(new PayPalPayment("user@example.com"));         // Output: Paid 300 using PayPal: user@example.com
    }
}

