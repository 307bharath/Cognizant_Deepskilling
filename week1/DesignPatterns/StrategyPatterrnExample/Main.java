package StrategyPatterrnExample;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay with Credit Card
        context.setPaymentStrategy(new CreditCardPayment("7649-5318-3810-1432", "Bharadwaj"));
        context.pay(100.0);

        // Pay with PayPal
        context.setPaymentStrategy(new PayPalPayment("bharadwaja@gmail.com"));
        context.pay(200.0);

        // No payment strategy set
        context.setPaymentStrategy(null);
        context.pay(300.0);
    }
}