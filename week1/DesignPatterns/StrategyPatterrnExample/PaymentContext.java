package StrategyPatterrnExample;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy == null) {
            System.out.println("\nFor transaction of $ "+amount+" No payment strategy selected.\n" +
                    "Please set a payment strategy before proceeding with the payment.\n");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
