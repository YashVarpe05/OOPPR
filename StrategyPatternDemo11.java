interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cvv;
    private String cardholderName;

    public CreditCardPayment(String cardNumber, String cvv, String cardholderName) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardholderName = cardholderName;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit Card");
        System.out.println("Card Number: " + cardNumber);
        System.out.println("Cardholder: " + cardholderName);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal");
        System.out.println("PayPal Email: " + email);
    }
}

class BitcoinPayment implements PaymentStrategy {
    private String bitcoinAddress;

    public BitcoinPayment(String bitcoinAddress) {
        this.bitcoinAddress = bitcoinAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Bitcoin");
        System.out.println("Bitcoin Address: " + bitcoinAddress);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private int totalAmount;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void addItem(int price) {
        totalAmount += price;
    }

    public void checkout() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        paymentStrategy.pay(totalAmount);
        totalAmount = 0;
    }
}

public class StrategyPatternDemo11 {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(100);
        cart.addItem(200);

        cart.setPaymentStrategy(new CreditCardPayment(
                "1234-5678-9012-3456",
                "123",
                "John Doe"));
        cart.checkout();

        cart.addItem(150);

        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        cart.checkout();

        cart.setPaymentStrategy(new BitcoinPayment("1BvBMSEYstWetqTFn5Au4m4GFg7xJaNVN2"));
        cart.checkout();
    }
}